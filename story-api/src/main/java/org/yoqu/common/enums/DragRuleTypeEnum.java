package org.yoqu.common.enums;

/**
 * Created by yoqu on 17-6-2.
 */
public enum DragRuleTypeEnum implements CodeBaseEnum{

    XPATH("XPATH","XPATH表达式"),JQUERY("JQUERY","Jquery表达式"),CSS("CSS","基于class筛选的表达式"),REGEX("REGEX","正则表达式");


    private String value;

    private String remark;

    DragRuleTypeEnum(String value,String remark){
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
