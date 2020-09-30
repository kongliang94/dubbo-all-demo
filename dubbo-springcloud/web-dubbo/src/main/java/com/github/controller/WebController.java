package com.github.controller;

import com.github.service.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class WebController {
    @Autowired
    private DubboService dubboService;

    @GetMapping("/test/{p}")
    public String test(@PathVariable("p") String param) {
        return dubboService.test(param);
    }
}
