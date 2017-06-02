package org.yoqu.story.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by yoqu on 17-5-31.
 */
public class Story {
    /**
     * 小说ID
     */
    private String id;
    /**
     * 小说名称
     */
    private String name;

    /**
     * 小说作者
     */
    private String author;

    /**
     * 网站源
     */
    private String resourceSite;

    /**
     * 最后一次的更新时间
     */
    private Date lastUpdateDate;

    /**
     * 最新章节
     */
    private String newChapter;

    /**
     * 图书的url
     */
    private String bookUrl;

    private List<Chapter> chapters;

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getResourceSite() {
        return resourceSite;
    }

    public void setResourceSite(String resourceSite) {
        this.resourceSite = resourceSite;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getNewChapter() {
        return newChapter;
    }

    public void setNewChapter(String newChapter) {
        this.newChapter = newChapter;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                ", newChapter='" + newChapter + '\'' +
                ", bookUrl='" + bookUrl + '\'' +
                '}';
    }
}
