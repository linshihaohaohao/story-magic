package org.yoqu.common.entity;

import java.util.Date;

/**
 * Created by yoqu on 17-6-2.
 */
public class ContentRule {

    private String id;

    private String site;

    private String contentRule;

    private String type;

    private Date createDate;

    private Date updateDate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getContentRule() {
        return contentRule;
    }

    public void setContentRule(String contentRule) {
        this.contentRule = contentRule;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "ContentRule{" +
                "id='" + id + '\'' +
                ", site='" + site + '\'' +
                ", contentRule='" + contentRule + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }


}
