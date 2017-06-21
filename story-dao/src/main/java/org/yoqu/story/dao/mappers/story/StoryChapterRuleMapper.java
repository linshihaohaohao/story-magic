package org.yoqu.story.dao.mappers.story;

import org.apache.ibatis.annotations.Mapper;
import org.yoqu.common.entity.rule.StoryChapterRulePo;
import org.yoqu.story.dao.mappers.BaseMapper;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/18
 * @time 12:00
 */
@Mapper
public interface StoryChapterRuleMapper extends BaseMapper<StoryChapterRulePo> {
    StoryChapterRulePo selectByStoryRuleId(String storyRuleId);
}
