package org.yoqu.story.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.story.dao.service.StoryRuleService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
public class StoryDaoApplicationTests {

	@Autowired
	private StoryRuleService storyRuleService;

	@Test
	public void testSelect(){
		List<StoryRulePo> result= storyRuleService.select();
		System.out.println(result);
	}

	@Test
	public void contextLoads() {
	}

}
