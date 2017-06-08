package org.yoqu.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yoqu.common.message.ResponseMessage;
import org.yoqu.frontend.controller.frontend.service.StoryService;

/**
 * @author yoqu
 * @date 2017年06月06日
 * @time 下午10:30
 * @email wcjiang2@iflytek.com
 */
@RestController
@RequestMapping("v1")
public class StoryController {
    @Autowired
    private  StoryService storyService;

    @GetMapping("search")
    public ResponseMessage searchBook(@RequestParam("name")String bookName){
        return storyService.searchBook(bookName);
    }

}
