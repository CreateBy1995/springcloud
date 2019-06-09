package com.sunshine.springcloud.consumer.module.service;

import com.sunshine.springcloud.consumer.module.impl.ProviderHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PROVIDER1" ,fallback = ProviderHystrix.class)
public interface ConsumerService {
    @RequestMapping("provider1")
    String getProvider1(@RequestParam("param") String param);
}
