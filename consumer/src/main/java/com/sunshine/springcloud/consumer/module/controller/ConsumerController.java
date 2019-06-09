package com.sunshine.springcloud.consumer.module.controller;

import com.netflix.discovery.converters.Auto;
import com.sunshine.springcloud.consumer.module.service.Consumer2Service;
import com.sunshine.springcloud.consumer.module.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService ;
    @Autowired
    private Consumer2Service consumer2Service ;
    @RequestMapping("provider1")
    public String getProvider1(String param){
        return consumerService.getProvider1(param) ;
    }
    @RequestMapping("provider2")
    public String getProvider2(String param){
        return consumer2Service.getProvider2(param) ;
    }
}
