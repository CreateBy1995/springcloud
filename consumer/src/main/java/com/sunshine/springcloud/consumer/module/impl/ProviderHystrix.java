package com.sunshine.springcloud.consumer.module.impl;

import com.sunshine.springcloud.consumer.module.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ProviderHystrix implements ConsumerService {
    @Override
    public String getProvider1(String param) {
        String result = "provider1 的 降级服务" ;
        return result;
    }
}
