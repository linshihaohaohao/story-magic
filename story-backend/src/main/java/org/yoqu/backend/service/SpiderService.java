package org.yoqu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yoqu.backend.config.SpiderProperties;
import org.yoqu.engine.SoduEngineProcessor;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import javax.annotation.PostConstruct;

/**
 * @author yoqu
 * @date 2017年06月03日
 * @time 下午11:18
 * @email wcjiang2@iflytek.com
 */
@Service
public class SpiderService {

    private Spider spider;

    @Autowired
    SpiderProperties spiderProperties;

    @Autowired
    SoduEngineProcessor soduEngineProcessor;

    @PostConstruct
    public void init(){
        spider = new Spider(soduEngineProcessor);
        spider.thread(spiderProperties.getThread());
        spider.addPipeline(new ConsolePipeline());
    }


    public void execute(Request request){
        spider.addRequest(request);
        spider.run();
    }

}
