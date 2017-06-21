package org.yoqu.story.dao.mappers.story;

import org.apache.ibatis.annotations.Mapper;
import org.hsweb.web.dao.GenericMapper;
import org.yoqu.common.entity.rule.StoryContentRulePo;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.story.dao.mappers.BaseMapper;

import java.util.List;

/**
 * Created by Kai on 2017/6/9.
 *
 * @Email zack.zhong@qq.com
 */
@Mapper
public interface StoryRuleMapper extends BaseMapper<StoryRulePo> {

    List<StoryRulePo> selectByStorySiteRuleId(String storySiteRuleId);

    StoryContentRulePo selectStoryContent(String storyRuleId);
}
