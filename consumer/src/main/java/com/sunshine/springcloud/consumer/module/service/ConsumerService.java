package com.sunshine.springcloud.consumer.module.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PROVIDER1")
public interface ConsumerService {
    @RequestMapping("provider1")
    String getProvider1(@RequestParam("param") String param);
}
