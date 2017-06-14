package org.yoqu.story.admin.restController;

import org.hsweb.web.controller.GenericController;
import org.hsweb.web.core.authorize.annotation.Authorize;
import org.hsweb.web.core.logger.annotation.AccessLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.common.entity.rule.StorySiteRulePo;
import org.yoqu.story.dao.service.StorySiteRuleService;


/**
 * Created by Admin on 2017/6/10.
 */

@RestController
@RequestMapping("api/site/story")
@Authorize(module = "storyRule") //权限验证
@AccessLogger("小说网站管理")   //访问日志描述
public class StoryRestController extends GenericController<StorySiteRulePo, String> {

    @Autowired
    StorySiteRuleService storySiteRuleService;

    @Override
    protected StorySiteRuleService getService() {
        return this.storySiteRuleService;
    }



}
