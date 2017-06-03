package org.yoqu.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.yoqu.common.message.ResponseMessage;

import static org.yoqu.common.message.ResponseMessage.ok;

/**
 * @author yoqu
 * @date 2017年06月03日
 * @time 下午10:39
 * @email wcjiang2@iflytek.com
 */
@RestController
public class StroyController {

    public ResponseMessage searchBook(){

        return ok();
    }

}
