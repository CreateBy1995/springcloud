package com.sunshine.springcloud.provider1.module.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    // 测试从config配置中心获取的值
    @Value("${name}")
    private String configName ;
    private static int requestCount = 0 ;
    @RequestMapping(value = "provider1" , method = RequestMethod.GET)
    public String provider(String param) throws InterruptedException {
        System.out.println(requestCount++);
        String result = "当前服务为provider1 --- 入参为 --- "+param+" --- 调用次数为 --- "+ ProviderController.requestCount ;
//        Thread.sleep(3000);
        return result ;
    }
    @RequestMapping(value = "testZuul/test" , method = RequestMethod.GET)
    public String testZuul(){
        System.out.println(requestCount++);
        return "testZuul_test" ;
    }


    @GetMapping("getConfig")
    public String getConfig(){
        return configName ;
    }
}
