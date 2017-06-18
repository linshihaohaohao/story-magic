package org.yoqu.story.dao.service.impl;

import org.hsweb.web.bean.common.QueryParam;
import org.springframework.stereotype.Service;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.story.dao.mappers.story.StoryRuleMapper;
import org.yoqu.story.dao.service.StoryRuleService;

import java.util.List;

/**
 * Created by Admin on 2017/6/9.
 */
@Service("StoryRuleService")
public class StoryRuleServiceImpl extends BaseServiceImpl<StoryRulePo,StoryRuleMapper> implements StoryRuleService{

    @Override
    public List<StoryRulePo> selectByType(String type){
        QueryParam queryParam = new QueryParam();
        queryParam.and("type","=",type);
        return getMapper().select(queryParam);
    }

    @Override
    public List<StoryRulePo>selectBySiteId(String id){
        QueryParam queryParam = new QueryParam();
        queryParam.and("storySiteRuleId","=",id);
        return getMapper().select(queryParam);
    }

}
