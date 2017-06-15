package org.yoqu.common.entity.rule;

import org.hsweb.web.bean.po.GenericPo;

import java.util.List;

/**
 * Created by k on 2017/6/13.
 */
public class StorySiteRulePo extends BaseRulePo{

    /** 网站名称*/
    private String name;

    /** 网站地址*/
    private String url;

    /** 网站类型*/
    private String type;

    /** 网站内容规则 */
    private List<StoryRulePo> storyRulePos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<StoryRulePo> getStoryRulePos() {
        return storyRulePos;
    }

    public void setStoryRulePos(List<StoryRulePo> storyRulePos) {
        this.storyRulePos = storyRulePos;
    }

    public interface Property extends GenericPo.Property{

        String name = "name";

        String url = "url";

        String type = "type";

        String storyRulePos = "storyRulePos";
    }
}
