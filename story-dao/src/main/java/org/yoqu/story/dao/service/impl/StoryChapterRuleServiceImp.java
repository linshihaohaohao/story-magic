package org.yoqu.story.dao.service.impl;

import org.hsweb.web.bean.common.QueryParam;
import org.springframework.stereotype.Service;
import org.yoqu.common.entity.rule.StoryChapterRulePo;
import org.yoqu.story.dao.mappers.story.StoryChapterRuleMapper;
import org.yoqu.story.dao.service.StoryChapterRuleService;

import java.util.List;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/18
 * @time 12:06
 */
@Service("storyChapterRuleService")
public class StoryChapterRuleServiceImp extends BaseServiceImpl<StoryChapterRulePo,StoryChapterRuleMapper> implements StoryChapterRuleService {



    @Override
    public StoryChapterRulePo selectByStoryId(String storyId) {
        QueryParam queryParam = new QueryParam();
        queryParam.and("story_rule_id","=",storyId);
        List<StoryChapterRulePo> storyChapterRulePos = getMapper().select(queryParam);
        return storyChapterRulePos.isEmpty()?null:storyChapterRulePos.get(0);
    }
}
