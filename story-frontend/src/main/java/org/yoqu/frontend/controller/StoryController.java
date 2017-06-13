package org.yoqu.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.common.message.ResponseMessage;
import org.yoqu.frontend.controller.frontend.service.StoryService;
import org.yoqu.story.dao.service.StoryRuleService;

import java.util.List;

/**
 * @author yoqu
 * @date 2017年06月06日
 * @time 下午10:30
 * @email wcjiang2@iflytek.com
 */
@RestController
@RequestMapping("api/${api-version}/")
public class StoryController {

    @Autowired
    private  StoryService storyService;

    @Autowired
    private StoryRuleService storyRuleService;

    @GetMapping("search")
    public ResponseMessage searchBook(@RequestParam("name")String bookName){
        List<StoryRulePo> storyRulePoList = storyRuleService.selectByType("search");
        return storyService.searchBook(bookName,storyRulePoList.get(0));
    }

    @GetMapping("repository")
    public ResponseMessage bookRepository(@RequestParam("name")String bookName,@RequestParam("bookUrl")String url){
        List<StoryRulePo> storyRulePoList = storyRuleService.selectByType("repository");
        return storyService.repository(bookName,url,storyRulePoList.get(0));
    }

}
