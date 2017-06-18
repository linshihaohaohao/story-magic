package org.yoqu.story.dao.service;

import org.yoqu.common.entity.rule.StoryChapterRulePo;
import org.yoqu.story.dao.mappers.story.StoryChapterRuleMapper;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/18
 * @time 12:05
 */
public interface StoryChapterRuleService extends BaseService<StoryChapterRulePo,StoryChapterRuleMapper> {

    StoryChapterRulePo selectByStoryId(String storyId);
}
