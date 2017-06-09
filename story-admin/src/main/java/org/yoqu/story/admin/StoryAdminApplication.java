package org.yoqu.story.admin;

import org.hsweb.web.core.authorize.annotation.Authorize;
import org.hsweb.web.mybatis.MybatisProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration//(exclude = MybatisAutoConfiguration.class)
@ComponentScan(basePackages = {"org.yoqu.story"})
@MapperScan("org.yoqu.story.admin.dao")
@Controller

public class StoryAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoryAdminApplication.class, args);
	}

	//指定使用hsweb的properties，
	@Bean
	@Primary
	public MybatisProperties mybatisProperties() {
		return new MybatisProperties();
	}

	@RequestMapping(value = {"/", "/index.html"})
	@Authorize
	public String index() {
		return "admin/index";
	}
}
