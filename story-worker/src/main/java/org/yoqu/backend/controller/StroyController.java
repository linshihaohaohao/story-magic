package org.yoqu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.backend.pipeline.StoryPipeline;
import org.yoqu.backend.service.SpiderService;
import org.yoqu.common.message.ResponseMessage;
import us.codecraft.webmagic.Request;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SpiderService spiderService;

    @Autowired
    private StoryPipeline storyPipeline;

    @GetMapping("search")
    public ResponseMessage searchBook(@RequestParam("name")String bookName){
        Request request = new Request();
        request.setUrl("http://www.sodu.cc/result.html?searchstr="+bookName);
        request.putExtra("type","search");
        spiderService.execute(request);
        return ok(storyPipeline.getResult());
    }

    @GetMapping("repository")
    public ResponseMessage repository(@RequestParam("url")String url,@RequestParam("name")String name){
        Request request = new Request();
        request.setUrl(url);
        request.putExtra("type","repository");
        request.putExtra("bookName",name);
        spiderService.execute(request);
        return ok(storyPipeline.getResult());
    }

    @GetMapping("chapter")
    public ResponseMessage chapter(@RequestParam("url")String url){
        Request request = new Request();
        request.setUrl(url);
        request.putExtra("type","chapters");
        spiderService.execute(request);
        return ok(storyPipeline.getResult());
    }
}
