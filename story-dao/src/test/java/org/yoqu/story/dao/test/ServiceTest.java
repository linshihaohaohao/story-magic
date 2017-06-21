package org.yoqu.story.dao.test;

import org.hsweb.web.bean.po.GenericPo;
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
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.common.entity.rule.StorySiteRulePo;
import org.yoqu.story.dao.service.StoryRuleService;
import org.yoqu.story.dao.service.StorySiteRuleService;

/**
 * Created by k on 2017/6/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = CMDWebSocketAutoConfiguration.class)
@SpringBootConfiguration
@ComponentScan(basePackages = {"org.yoqu.story"})
@Controller
public class ServiceTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    StoryRuleService storyRuleService;

    @Autowired
    StorySiteRuleService storySiteRuleService;

//    @Override
//    protected StoryRuleService getService() {
//        return this.storyRuleService;
//    }


    @Test
    public void insert() {
        StoryRulePo storyRulePo = new StoryRulePo();
        storyRulePo.setBookName("小水哦");
//        storyRulePo.setId("2");
//        storyRulePo.setId();
        storyRulePo.setId(GenericPo.createUID());
        storyRulePo.setAuthorName("名称");
        storyRuleService.saveOrUpdate(storyRulePo);
    }

    @Test
    public void getStorySite(){
//      List<StorySiteRulePo> storySiteRulePos = storySiteRuleService.select();
//      System.out.println(storySiteRulePos);
        StorySiteRulePo so = new StorySiteRulePo();
        so.setName("起点");
        so.setUrl("http://www.qidian.com/");
        so.setType("小说");
        storySiteRuleService.insert(so);
    }

}
