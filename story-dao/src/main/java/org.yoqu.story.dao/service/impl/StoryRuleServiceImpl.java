package org.yoqu.story.dao.service.impl;

import org.hsweb.web.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.story.dao.mappers.StoryRuleMapper;
import org.yoqu.story.dao.service.StoryRuleService;

/**
 * Created by Admin on 2017/6/9.
 */
@Service("StoryRuleService")
public class StoryRuleServiceImpl extends BaseServiceImpl<StoryRulePo> implements StoryRuleService{

    @Autowired
    private StoryRuleMapper storyRuleMapper;

    @Override
    protected StoryRuleMapper getMapper(){return storyRuleMapper;}


}
