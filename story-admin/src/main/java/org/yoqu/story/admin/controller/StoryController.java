package org.yoqu.story.admin.controller;

import org.hsweb.web.controller.GenericController;
import org.hsweb.web.core.authorize.annotation.Authorize;
import org.hsweb.web.core.logger.annotation.AccessLogger;
import org.hsweb.web.core.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.story.dao.service.StoryRuleService;

/**
 * Created by Admin on 2017/6/10.
 */

@RestController
@RequestMapping("/myTest")
@Authorize(module = "module") //权限验证
@AccessLogger("测试模块")   //访问日志描述
public class StoryController extends GenericController<StoryRulePo, String> {

    @Autowired
    StoryRuleService storyRuleService;

    @Override
    protected StoryRuleService getService() {
        return this.storyRuleService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseMessage getProfile() {
        StoryRulePo storyRulePo = new StoryRulePo();
        storyRulePo.setBookName("小水哦");
        storyRulePo.setAuthorName("名称");
        return  ResponseMessage.ok( storyRuleService.insert(storyRulePo));
    }


}
