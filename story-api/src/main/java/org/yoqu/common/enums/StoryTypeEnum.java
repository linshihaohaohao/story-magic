package org.yoqu.common.enums;

/**
 * Created by Admin on 2017/6/19.
 */
public enum StoryTypeEnum implements CodeBaseEnum {

    content("content","内容"),search("search","搜索"),repository("repository","数据源"),chapter("chapter","章节");

    private String value;

    private String remark;

    StoryTypeEnum(String value, String remark){
        this.value = value;
        this.remark = remark;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String value() {
        return getValue();
    }
}
