package org.yoqu.story.admin;

import org.apache.ibatis.annotations.Mapper;
import org.hsweb.web.core.authorize.annotation.Authorize;
import org.hsweb.web.mybatis.MybatisProperties;
import org.hsweb.web.socket.CMDWebSocketAutoConfiguration;
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
@EnableAutoConfiguration(exclude = CMDWebSocketAutoConfiguration.class)
@ComponentScan(basePackages = {"org.yoqu.story"})
@Controller
public class StoryAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoryAdminApplication.class, args);
	}



	@RequestMapping(value = {"/", "/index.html"})
	@Authorize
	public String index() {
		return "admin/index";
	}
}
