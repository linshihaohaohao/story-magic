package org.yoqu;

import org.hsweb.web.bean.po.GenericPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.common.enums.StoryTypeEnum;
import org.yoqu.story.dao.service.StoryRuleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoryFrontendApplicationTests {


	@Autowired
	private StoryRuleService storyRuleService;

	@Test
	public void contextLoads() {
		StoryRulePo storyRulePo = new StoryRulePo();
		storyRulePo.setId(GenericPo.createUID());
		storyRulePo.setType(StoryTypeEnum.search);
		storyRulePo.setBookName("Hello");
		storyRuleService.insert(storyRulePo);

	}

}
