package org.yoqu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yoqu.backend.pipeline.StoryPipeline;
import org.yoqu.backend.service.SpiderService;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.common.message.ResponseMessage;
import us.codecraft.webmagic.Request;

import static org.yoqu.common.message.ResponseMessage.ok;

/**
 * @author yoqu
 * @date 2017年06月03日
 * @time 下午10:39
 * @email wcjiang2@iflytek.com
 */
@RestController
@RequestMapping("/book")
public class StroyController {
//
//    @Autowired
//    private HttpServletRequest request;

    @Autowired
    private SpiderService spiderService;

    @Autowired
    private StoryPipeline storyPipeline;

    @PostMapping("search")
    public ResponseMessage searchBook(@RequestParam("name")String bookName, @RequestBody StoryRulePo storyRulePo){
        Request request = new Request();
        request.setUrl(storyRulePo.getUrl()+bookName);//"http://www.sodu.cc/result.html?searchstr="+bookName);
        request.putExtra("storyRulePo",storyRulePo);
        spiderService.execute(request);
        return ok(storyPipeline.getResultData());
    }

    @PostMapping("repository")
    public ResponseMessage repository(@RequestParam("name")String name,@RequestParam("url")String bookUrl ,@RequestBody StoryRulePo storyRulePo){
        Request request = new Request();
        request.setUrl(bookUrl);
        request.putExtra("bookName",name);
        request.putExtra("storyRulePo",storyRulePo);
        spiderService.execute(request);
        return ok(storyPipeline.getResultData());
    }

    @PostMapping("chapter")
    public ResponseMessage chapter(@RequestParam("url")String url,@RequestBody StoryRulePo storyRulePo){
        Request request = new Request();
        request.setUrl(url);
        request.putExtra("storyRulePo",storyRulePo);
        request.putExtra("isChapterList","false");
        spiderService.execute(request);
        return ok(storyPipeline.getResultData());
    }


    @PostMapping("content")
    ResponseMessage content(@RequestParam("url") String url, @RequestBody StoryRulePo storyRulePo){
        Request request = new Request();
        request.setUrl(url);
        request.putExtra("storyRulePo",storyRulePo);
        spiderService.execute(request);
        return ok(storyPipeline.getResultData());
    }
}
