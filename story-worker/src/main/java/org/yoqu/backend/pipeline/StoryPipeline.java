package org.yoqu.backend.pipeline;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yoqu
 * @date 2017年06月04日
 * @time 上午9:33
 * @email wcjiang2@iflytek.com
 */
@Component
public class StoryPipeline implements Pipeline {

    private Map<String, Object> result = new HashMap<>();

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("get page: " + resultItems.getRequest().getUrl());
        result.put("data",resultItems.get("data"));
    }

    public Map getResult(){
        return this.result;
    }

    public Object getResultData(){
        return this.result.get("data");
    }
}
