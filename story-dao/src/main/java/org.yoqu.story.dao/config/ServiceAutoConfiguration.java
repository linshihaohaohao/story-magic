package org.yoqu.story.dao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Admin on 2017/6/10.
 */
@Configuration
@ComponentScan(basePackages = {"org.yoqu.story.dao.service.impl"}
)
public class ServiceAutoConfiguration {
}
