package com.github.service;

import org.apache.dubbo.config.annotation.Service;


@Service(protocol = "dubbo")
public class DubboServiceImpl implements DubboService {

    @Override
    public String test(String param) {
        return "dubbo service: " + param;
    }
}
