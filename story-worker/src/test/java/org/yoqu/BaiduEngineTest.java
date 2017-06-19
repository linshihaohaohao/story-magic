package org.yoqu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yoqu.backend.engine.SoduEngineProcessor;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.common.enums.DragRuleTypeEnum;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 * Created by yoqu on 17-5-31.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
public class BaiduEngineTest {

    /**
     * 测试小说搜索
     */
    @Test
    public void testSearch(){
        Request request = new Request();
        request.putExtra("type","search");
        request.setUrl("http://www.sodu.cc/result.html?searchstr=斗罗大陆");
        Spider.create(new SoduEngineProcessor()).addPipeline(new ConsolePipeline()).addRequest(request).thread(5).run();
    }

    @Test
    public void testPo(){
        StoryRulePo s = new StoryRulePo();
        s.setBookName("asiuq");

        System.out.println(s.getProperty("bookName").toString());
    }

    /**
     * 测试小说源
     */
    @Test
    public void testRepository(){
        Request request = new Request();
        request.putExtra("type","repository");
        request.setUrl("http://www.sodu.cc/mulu_369159.html");
        request.putExtra("bookName","斗罗大陆");
        Spider.create(new SoduEngineProcessor()).addPipeline(new ConsolePipeline()).addRequest(request).thread(5).run();
    }


    /**
     * 测试小说章节
     */
    @Test
    public void testChapter(){
        Request request = new Request();
        request.putExtra("type","chapters");
        request.setUrl("http://www.sodu.cc/newmulu_6037_35.html");
        Spider.create(new SoduEngineProcessor()).addPipeline(new ConsolePipeline()).addRequest(request).thread(5).run();
    }

    /**
     * 测试小说章节
     */
    @Test
    public void testContent(){
        Request request = new Request();
        request.putExtra("type","content");
        request.putExtra("contentRule","//div[@id='content']");
        request.putExtra("ruleType", DragRuleTypeEnum.XPATH.getValue());
        request.setUrl("http://www.muyuge.com/0_288/24058890.html");
        Spider.create(new SoduEngineProcessor()).addPipeline(new ConsolePipeline()).addRequest(request).thread(5).run();
    }
}
