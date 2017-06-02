package org.yoqu.common.enums;

/**
 * Created by yoqu on 17-6-2.
 */
public enum DragRuleTypeEnum {

    XPATH("xpath","XPATH表达式"),JQUERY("jquery","jquery表达式"),CSS("css","基于class筛选的表达式"),REGEX("regex","正则表达式");


    private String value;

    private String remark;

    private DragRuleTypeEnum(String value,String remark){
        this.value = value;
        this.remark = remark;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
