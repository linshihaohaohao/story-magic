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
    private String ContentRule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getContentRule() {
        return ContentRule;
    }

    public void setContentRule(String contentRule) {
        ContentRule = contentRule;
    }

    public String getStoryRuleId() {

        return storyRuleId;
    }

    public void setStoryRuleId(String storyRuleId) {
        this.storyRuleId = storyRuleId;
    }
    public interface Property extends GenericPo.Property{

        String name = "name";

        String storyRuleId = "storyRuleId";
        String chapterRuleListRule = "chapterRuleListRule";
    }
}
