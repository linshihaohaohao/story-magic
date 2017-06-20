package org.yoqu.story.admin.restController;

import org.hsweb.web.controller.GenericController;
import org.hsweb.web.core.authorize.annotation.Authorize;
import org.hsweb.web.core.logger.annotation.AccessLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.common.entity.rule.StoryContentRulePo;
import org.yoqu.story.dao.service.StoryContentRuleService;

/**
 * Created by Admin on 2017/6/20.
 */
@RestController
@RequestMapping("api/site/story/content")
@Authorize(module = "storyRule") //权限验证
@AccessLogger("小说网站管理 - 编辑内容规则")   //访问日志描述
public class StoryContentRestController extends GenericController<StoryContentRulePo,String>{

    @Autowired
    private StoryContentRuleService storyContentRuleService;

    @Override
    protected StoryContentRuleService getService(){
        return this.storyContentRuleService;
    }

}
