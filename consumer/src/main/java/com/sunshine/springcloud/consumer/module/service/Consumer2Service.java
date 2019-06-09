package com.sunshine.springcloud.consumer.module.service;

import com.sunshine.springcloud.consumer.module.impl.Provider2Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PROVIDER2",fallback = Provider2Hystrix.class)
public interface Consumer2Service {
    @RequestMapping("provider2")
    String getProvider2(@RequestParam("param") String param);
}
