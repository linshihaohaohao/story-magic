package org.yoqu;

import org.hsweb.web.controller.ControllerAutoConfiguration;
import org.hsweb.web.starter.SystemInitializeAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = {ControllerAutoConfiguration.class, SystemInitializeAutoConfiguration.class})
public class StoryFrontendApplication {
	public static void main(String[] args) {
		SpringApplication.run(StoryFrontendApplication.class, args);
	}
}