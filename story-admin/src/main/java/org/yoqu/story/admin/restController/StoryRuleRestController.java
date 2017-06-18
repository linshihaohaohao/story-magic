package org.yoqu.story.admin.restController;

import org.hsweb.web.controller.GenericController;
import org.hsweb.web.core.authorize.annotation.Authorize;
import org.hsweb.web.core.logger.annotation.AccessLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.story.dao.service.StoryRuleService;

/**
 * Created by Admin on 2017/6/16.
 */

@RestController
@RequestMapping("api/site/storyRule")
@Authorize(module = "storyRule") //权限验证
@AccessLogger("小说网站管理")   //访问日志描述
public class StoryRuleRestController extends GenericController<StoryRulePo, String> {
    @Autowired
    StoryRuleService storyRuleService;
    @Override
    protected StoryRuleService getService() {
        return this.storyRuleService;
    }
}
