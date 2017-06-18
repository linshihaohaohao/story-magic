package org.yoqu.story.dao.service;

import org.hsweb.web.service.GenericService;
import org.yoqu.common.entity.Story;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.story.dao.mappers.story.StoryRuleMapper;

import java.util.List;

/**
 * Created by Kai on 2017/6/9.
 *
 * @Email zack.zhong@qq.com
 */
public interface StoryRuleService extends BaseService<StoryRulePo,StoryRuleMapper> {
    List<StoryRulePo> selectByType(String type);

    StoryRulePo selectByResource(String url, String type);

    List<StoryRulePo> selectBySiteId(String id);
}
