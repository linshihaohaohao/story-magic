package org.yoqu.story.admin.restController;

import org.hsweb.web.bean.po.GenericPo;
import org.hsweb.web.controller.GenericController;
import org.hsweb.web.core.authorize.annotation.Authorize;
import org.hsweb.web.core.logger.annotation.AccessLogger;
import org.hsweb.web.core.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.yoqu.common.entity.rule.StoryContentRulePo;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.common.entity.rule.StorySiteRulePo;
import org.yoqu.story.dao.service.StoryChapterRuleService;
import org.yoqu.story.dao.service.StoryContentRuleService;
import org.yoqu.story.dao.service.StoryRuleService;
import org.yoqu.story.dao.service.StorySiteRuleService;

import java.util.ArrayList;
import java.util.List;


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

    @Autowired
    StoryRuleService storyRuleService;

    @Autowired
    StoryContentRuleService storyContentRuleService;

    @Autowired
    StoryChapterRuleService storyChapterRuleService;

    @Override
    protected StorySiteRuleService getService() {
        return this.storySiteRuleService;
    }


    @RequestMapping(
            value = {"save"},
            method = {RequestMethod.POST}
    )
    @AccessLogger("修改")
    public ResponseMessage save(@RequestBody StorySiteRulePo object) {
        List<String> saveRuleIDs = new ArrayList<>();
        String poId = storySiteRuleService.save(object);
        if (null != object.getStoryRulePos()) {
            for (StoryRulePo storyRulePo : object.getStoryRulePos()) {
                if (null == storyRulePo.getStorySiteRuleId()) {
                    storyRulePo.setStorySiteRuleId(poId);
                }
                String ruleId = storyRuleService.save(storyRulePo);
                if(null != storyRulePo.getStoryChapterRulePo()){
                    storyRulePo.getStoryChapterRulePo().setStoryRuleId(ruleId);
                    storyChapterRuleService.save(storyRulePo.getStoryChapterRulePo());
                }
                if(null != storyRulePo.getStoryContentRulePo()){
                    storyRulePo.getStoryContentRulePo().setStoryRuleId(ruleId);
                    storyContentRuleService.save(storyRulePo.getStoryContentRulePo());
                }
                saveRuleIDs.add(ruleId);
            }
        }
        //新建时若保存失败,则删除已存的site
        if( null == object.getId() && (saveRuleIDs.size() < object.getStoryRulePos().size())){
            storySiteRuleService.delete(poId);
        }
        //
//        if(!CollectionUtils.isEmpty(saveRuleIDs)){
//            List<StoryRulePo> allRuleBy = storyRuleService.selectBySiteId(object.getId());
//            for (String ruleID : saveRuleIDs){
//                for (StoryRulePo storyRulePo : allRuleBy){
//                    if(ruleID.equals(storyRulePo.getId())){
//                        allRuleBy.remove(storyRulePo);
//                    }
//                }
//            }
//            for (StoryRulePo storyRulePo : allRuleBy){
//                storyRuleService.delete(storyRulePo.getId());
//            }
//        }


        return ResponseMessage.ok(poId == null ? 0 : 1);
    }

}
