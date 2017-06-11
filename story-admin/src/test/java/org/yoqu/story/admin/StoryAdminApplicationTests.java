package org.yoqu.story.admin;

import org.hsweb.web.socket.CMDWebSocketAutoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.yoqu.story.dao.service.StoryRuleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = CMDWebSocketAutoConfiguration.class)
@SpringBootConfiguration
@ComponentScan(basePackages = {"org.yoqu.story"})
@Controller
public class StoryAdminApplicationTests {

	@Autowired
	private StoryRuleService storyRuleService;

	@Test
	public void contextLoads() {
		System.out.println(storyRuleService.select());
	}

}
