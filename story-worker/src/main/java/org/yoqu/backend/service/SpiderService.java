package org.yoqu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.yoqu.backend.config.SpiderProperties;
import org.yoqu.backend.pipeline.StoryPipeline;
import org.yoqu.backend.engine.SoduEngineProcessor;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;

import javax.annotation.PostConstruct;

/**
 * @author yoqu
 * @date 2017年06月03日
 * @time 下午11:18
 * @email wcjiang2@iflytek.com
 */
@Service
@EnableConfigurationProperties(SpiderProperties.class)
public class SpiderService {

    private Spider spider;
    private boolean isRunning=false;
    @Autowired
    SpiderProperties spiderProperties;

    @Autowired
    SoduEngineProcessor soduEngineProcessor;

    @Autowired
    StoryPipeline storyPipeline;

    @PostConstruct
    public void init(){
        spider = new Spider(soduEngineProcessor);

        spider.thread(spiderProperties.getThread());
        spider.addPipeline(storyPipeline);
    }


    public void execute(Request request){
        spider.addRequest(request);
        if(!isRunning){
            isRunning=true;
            spider.run();
            isRunning=false;
        }else{

        }
    }

}
