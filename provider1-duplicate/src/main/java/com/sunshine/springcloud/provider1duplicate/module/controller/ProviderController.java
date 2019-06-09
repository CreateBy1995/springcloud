package com.sunshine.springcloud.provider1duplicate.module.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    private static int requestCount = 0 ;
    @RequestMapping(value = "provider1" , method = RequestMethod.GET)
    public String provider(String param) throws InterruptedException {
        System.out.println(requestCount++);
        String result = "当前服务为provider1duplicate --- 入参为 --- "+param+" --- 调用次数为 --- "+ ProviderController.requestCount ;
        Thread.sleep(3000);
        return result ;
    }
}
