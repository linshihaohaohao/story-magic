package org.yoqu.common.entity.rule;

import org.hsweb.web.bean.po.GenericPo;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/18
 * @time 12:01
 */
public class StoryContentRulePo extends BaseRulePo {

    /**
     * 对应的小说规则Id
     */
    private String storyRuleId;

    private String name;

    /**
     * 小说内容
     */
    private String contentRule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentRule() {
        return contentRule;
    }

    public void setContentRule(String contentRule) {
        this.contentRule = contentRule;
    }

    public String getStoryRuleId() {

        return storyRuleId;
    }

    public void setStoryRuleId(String storyRuleId) {
        this.storyRuleId = storyRuleId;
    }
    public interface Property extends GenericPo.Property{
        String storyRuleId = "storyRuleId";
        String name = "name";
        String chapterRuleListRule = "contentRule";
    }
}
