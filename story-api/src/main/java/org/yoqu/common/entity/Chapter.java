package org.yoqu.common.entity;

import java.util.Date;

/**
 * Created by yoqu on 17-5-31.
 */
public class Chapter {
    private String id;
    private String name;
    private Date updateDate;
    private String readUrl ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getReadUrl() {
        return readUrl;
    }

    public void setReadUrl(String readUrl) {
        this.readUrl = readUrl;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", updateDate=" + updateDate +
                ", readUrl='" + readUrl + '\'' +
                '}';
    }
}
