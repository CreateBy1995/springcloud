package com.sunshine.springcloud.provider2.module.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    private static int requestCount = 0 ;
    @RequestMapping(value = "provider2" , method = RequestMethod.GET)
    public String provider(String param) throws InterruptedException {
        System.out.println(requestCount++);
        Thread.sleep(3000);
        String result = "当前服务为provider2 --- 入参为 --- "+param+" --- 调用次数为 --- "+ ProviderController.requestCount ;
        return result ;
    }
}
