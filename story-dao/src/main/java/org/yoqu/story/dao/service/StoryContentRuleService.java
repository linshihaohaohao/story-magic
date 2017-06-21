package org.yoqu.story.dao.service;

import org.yoqu.common.entity.rule.StoryContentRulePo;
import org.yoqu.story.dao.mappers.story.StoryContentRuleMapper;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/18
 * @time 12:05
 */
public interface StoryContentRuleService extends BaseService<StoryContentRulePo,StoryContentRuleMapper> {

    StoryContentRulePo selectByStoryId(String storyId);
}
