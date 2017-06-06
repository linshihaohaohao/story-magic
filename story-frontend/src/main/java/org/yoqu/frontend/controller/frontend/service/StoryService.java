package org.yoqu.frontend.controller.frontend.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("search")
    ResponseMessage searchBook(@RequestParam("name")String bookName);
}
