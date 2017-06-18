package org.yoqu.story.dao.service.impl;

import org.hsweb.web.bean.common.QueryParam;
import org.springframework.stereotype.Service;
import org.yoqu.common.entity.rule.StoryContentRulePo;
import org.yoqu.story.dao.mappers.story.StoryContentRuleMapper;
import org.yoqu.story.dao.service.StoryContentRuleService;

import java.util.List;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/18
 * @time 12:06
 */
@Service("storyContentRuleServiceImp")
public class StoryContentRuleServiceImp extends BaseServiceImpl<StoryContentRulePo,StoryContentRuleMapper> implements StoryContentRuleService {


    @Override
    public StoryContentRulePo selectByStoryId(String storyId) {
        QueryParam queryParam = new QueryParam();
        queryParam.and("story_rule_id","=",storyId);
        List<StoryContentRulePo> storyContentRulePos = getMapper().select(queryParam);
        return storyContentRulePos.isEmpty()?null:storyContentRulePos.get(0);
    }
}
