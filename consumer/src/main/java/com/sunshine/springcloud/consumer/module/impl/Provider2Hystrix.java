package com.sunshine.springcloud.consumer.module.impl;

import com.sunshine.springcloud.consumer.module.service.Consumer2Service;
import org.springframework.stereotype.Service;

@Service
public class Provider2Hystrix implements Consumer2Service {
    @Override
    public String getProvider2(String param) {
        String result = "provider2 的降级服务" ;
        return result ;
    }
}
