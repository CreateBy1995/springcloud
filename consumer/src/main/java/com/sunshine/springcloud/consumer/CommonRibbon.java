package com.sunshine.springcloud.consumer;

import com.sunshine.springcloud.config.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "PROVIDER2", configuration = RibbonConfiguration.class)
/**
 * 如果直接将Ribbon的配置类（RibbonConfiguration.class）放在和 SpringBoot启动类同一包或者其子包下  则当前Ribbon配置会被所有RibbonClient共享
 * 所以需要通过指定的方式配置  指定的的配置类放在其他的包中
 */
public class CommonRibbon {
}
