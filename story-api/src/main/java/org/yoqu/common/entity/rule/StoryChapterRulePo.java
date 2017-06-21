package org.yoqu.common.entity.rule;

import org.hsweb.web.bean.po.GenericPo;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/18
 * @time 12:01
 */
public class StoryChapterRulePo extends BaseRulePo {

    /**
     * 对应的小说规则Id
     */
    private String storyRuleId;

    private String name;

    /**
     * 链接到小说简介章节页面的规则
     */
    private String chapterListPageRule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChapterListPageRule() {
        return chapterListPageRule;
    }

    public void setChapterListPageRule(String chapterListPageRule) {
        this.chapterListPageRule = chapterListPageRule;
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
