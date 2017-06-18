package org.yoqu.frontend.controller.frontend.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.yoqu.common.entity.rule.StoryChapterRulePo;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.common.message.ResponseMessage;

/**
 * @author yoqu
 * @date 2017年06月06日
 * @time 下午11:00
 * @email wcjiang2@iflytek.com
 */
@FeignClient("worker-service")
@RequestMapping("/book")
public interface StoryService {

    @PostMapping("search")
    ResponseMessage searchBook(@RequestParam("name") String bookName, @RequestBody() StoryRulePo storyRulePo);

    @PostMapping("repository")
    ResponseMessage repository(@RequestParam("name") String name, @RequestParam("url") String bookUrl, @RequestBody StoryRulePo storyRulePo);

    @PostMapping("chapter")
    ResponseMessage chapter(@RequestParam("url") String url, @RequestBody StoryRulePo storyRulePo);

    @PostMapping("content")
    ResponseMessage content(@RequestParam("url") String url, @RequestBody StoryRulePo storyRulePo);
}
