package org.yoqu.story.dao.mappers.story;

import org.apache.ibatis.annotations.Mapper;
import org.yoqu.common.entity.rule.StoryChapterRulePo;
import org.yoqu.common.entity.rule.StoryContentRulePo;
import org.yoqu.story.dao.mappers.BaseMapper;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/18
 * @time 12:00
 */
@Mapper
public interface StoryContentRuleMapper extends BaseMapper<StoryContentRulePo> {
    StoryContentRulePo selectByStoryRuleId(String storyRuleId);
}
