package org.yoqu.story.admin.restController;

import org.hsweb.web.controller.GenericController;
import org.hsweb.web.core.authorize.annotation.Authorize;
import org.hsweb.web.core.logger.annotation.AccessLogger;
import org.hsweb.web.core.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.common.enums.DragRuleTypeEnum;
import org.yoqu.common.enums.StoryTypeEnum;
import org.yoqu.story.dao.handler.util.CodeEnumUtil;
import org.yoqu.story.dao.service.StoryRuleService;

import java.util.*;

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

    @RequestMapping(
            value = {"ruleType"},
            method = {RequestMethod.GET}
    )
    @AccessLogger("获取")
    public List<Map<String,String>> getStoryRuleType() {
//        List<Map<String,String>> returnData = new ArrayList<>();
//        for(DragRuleTypeEnum typeEnum : DragRuleTypeEnum.values()){
//            Map<String,String> typeMap = new HashMap<>();
//            typeMap.put("data",typeEnum.getValue());
//            returnData.add(typeMap);
//        }
        return CodeEnumUtil.getListMapEnum(DragRuleTypeEnum.class,"data");
    }

    @RequestMapping(
            value = {"storyType"},
            method = {RequestMethod.GET}
    )
    @AccessLogger("获取")
    public List<Map<String,String>> getStoryType() {
        return CodeEnumUtil.getListMapEnum(StoryTypeEnum.class,"data");
    }
}
