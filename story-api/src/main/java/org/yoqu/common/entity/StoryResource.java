package org.yoqu.common.entity;

import java.util.Date;
import java.util.List;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/17
 * @time 10:14
 */
public class StoryResource {
    List<StoryResourceContent> storyResourceContents;
    private String bookName;
    private String host;
    private String url;
    private Date updateTime;
    private Chapter lastChapter;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Chapter getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(Chapter lastChapter) {
        this.lastChapter = lastChapter;
    }

    public List<StoryResourceContent> getStoryResourceContents() {
        return storyResourceContents;
    }

    public void setStoryResourceContents(List<StoryResourceContent> storyResourceContents) {
        this.storyResourceContents = storyResourceContents;
    }
}
