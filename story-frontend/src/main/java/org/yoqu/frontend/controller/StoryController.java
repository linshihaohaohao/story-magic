package org.yoqu.frontend.controller;

import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.common.entity.rule.StoryChapterRulePo;
import org.yoqu.common.entity.rule.StoryContentRulePo;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.common.message.ResponseMessage;
import org.yoqu.frontend.controller.frontend.service.StoryService;
import org.yoqu.story.dao.service.StoryChapterRuleService;
import org.yoqu.story.dao.service.StoryContentRuleService;
import org.yoqu.story.dao.service.StoryRuleService;

import java.util.List;

import static org.yoqu.common.message.ResponseMessage.error;
import static org.yoqu.common.message.ResponseMessage.ok;

/**
 * @author yoqu
 * @date 2017年06月06日
 * @time 下午10:30
 * @email wcjiang2@iflytek.com
 */
@ApiModel(value = "小说阅读API")
@RestController
@RequestMapping("api/${api-version}/")
public class StoryController {

    @Autowired
    private  StoryService storyService;

    @Autowired
    private StoryRuleService storyRuleService;

    @Autowired
    private StoryChapterRuleService storyChapterRuleService;

    @Autowired
    private StoryContentRuleService storyContentRuleService;

    @ApiOperation(value = "搜索小说",notes = "通过输入小说的名字来进行搜索匹配")
    @GetMapping("search")
    public ResponseMessage searchBook(@ApiParam(value = "小说名字",defaultValue = "逆鳞")@RequestParam("name")String bookName){
        List<StoryRulePo> storyRulePoList = storyRuleService.selectByType("search");
        return storyService.searchBook(bookName,storyRulePoList.get(0));
    }

    @ApiOperation(value = "小说源选择切换",notes = "选择小说源")
    @GetMapping("repository")
    public ResponseMessage bookRepository(@ApiParam(value = "小说名字",defaultValue = "逆鳞")@RequestParam("name")String bookName
            ,@ApiParam(value = "小说的url，该url为搜索结果中得到的url",defaultValue = "http://www.sodu.cc/mulu_26997.html") @RequestParam("bookUrl")String url){
        List<StoryRulePo> storyRulePoList = storyRuleService.selectByType("repository");
        return storyService.repository(bookName,url,storyRulePoList.get(0));
    }

    @ApiOperation(value = "小说章节展示",notes = "小说章节展示")
    @GetMapping("chapter")
    public ResponseMessage bookChapter(@ApiParam(value = "小说名字",defaultValue = "逆鳞")@RequestParam("name")String name,
                                       @ApiParam(value = "通过源筛选得到的url",defaultValue = "http://www.muyuge.com/45_45382/24146702.html")@RequestParam("bookUrl")String url){
        StoryRulePo storyRulePo = storyRuleService.selectByResource(url,"chapter");
        if(storyRulePo==null){
            return error("没有找到该源");
        }
        StoryChapterRulePo storyChapterRulePo = storyChapterRuleService.selectByStoryId(storyRulePo.getId());
        storyRulePo.setStoryChapterRulePo(storyChapterRulePo);
        return storyService.chapter(url,storyRulePo);
    }

    @ApiOperation(value = "小说内容显示",notes = "小说内容")
    @GetMapping("content")
    public ResponseMessage bookContent(@ApiParam(value = "小说名字",defaultValue = "逆鳞")@RequestParam("name")String name,
                                       @ApiParam(value = "通过源筛选得到的url",defaultValue = "http://www.muyuge.com/45_45382/24146702.html")@RequestParam("bookUrl")String url){
        StoryRulePo storyRulePo = storyRuleService.selectByResource(url,"content");
        if(storyRulePo==null){
            return error("没有找到该源");
        }
        StoryContentRulePo storyContentRulePo = storyContentRuleService.selectByStoryId(storyRulePo.getId());
        storyRulePo.setStoryContentRulePo(storyContentRulePo);
        return storyService.content(url,storyRulePo);
    }

}
