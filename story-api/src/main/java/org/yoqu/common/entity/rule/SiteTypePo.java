package org.yoqu.common.entity.rule;

import org.hsweb.web.bean.po.GenericPo;

/**
 * Created by Admin on 2017/6/15.
 */
public class SiteTypePo extends BaseRulePo {
    /**名称*/
    private String name;
    /**值*/
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public interface Property extends GenericPo.Property{

        String name = "name";

        String value = "value";

    }

}
