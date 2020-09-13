package com.lagou;


import com.lagou.bean.ConsumerComponent;
import com.lagou.service.HelloService;
import com.sun.org.apache.xpath.internal.functions.FuncTrue;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class XMLConsumerMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        ClassPathXmlApplicationContext   app  = new ClassPathXmlApplicationContext("consumer.xml");
        HelloService  service = app.getBean(HelloService.class);
        while (true) {
            System.in.read();
            try {
                String hello = service.sayHello("world", 100);
                // 利用Future 模式来获取
                Future<Object>  future  = RpcContext.getContext().getFuture();
                System.out.println("result :" + hello);
                new Thread(()->{
                    try {
                        Thread.sleep(1000);
                        System.out.println("future result:"+future.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
