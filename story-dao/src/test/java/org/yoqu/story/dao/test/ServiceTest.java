package org.yoqu.story.dao.test;

import org.apache.ibatis.annotations.Mapper;
import org.hsweb.web.bean.po.GenericPo;
import org.hsweb.web.controller.GenericController;
import org.hsweb.web.core.message.ResponseMessage;
import org.hsweb.web.mybatis.MybatisProperties;
import org.hsweb.web.socket.CMDWebSocketAutoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.story.dao.service.StoryRuleService;

/**
 * Created by k on 2017/6/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceTest.class)
@ComponentScan(basePackages = {"org.yoqu.story"})
@MapperScan(value = "org.yoqu.story.dao.mappers",annotationClass = Mapper.class)
public class ServiceTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    StoryRuleService storyRuleService;

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
         String id = storyRuleService.insert(storyRulePo);
         System.out.println(id);
    }

}
