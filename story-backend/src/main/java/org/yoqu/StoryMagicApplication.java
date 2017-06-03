package org.yoqu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties
public class StoryMagicApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoryMagicApplication.class, args);
	}
}
