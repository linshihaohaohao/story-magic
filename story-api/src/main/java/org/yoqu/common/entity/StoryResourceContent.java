package org.yoqu.common.entity;

import java.util.Date;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/17
 * @time 10:18
 */
public class StoryResourceContent {
    private String id;
    private String bookName;
    private String description;
    private String label;
    private String status;
    private String url;
    private String sourceImageUrl;
    private String host;
    private String view;
    private Date updateTime;
    private Date createTime;
    private Long chapterCount;
    private Long wordCount;
    private String bookId;
    private String lastChapterName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSourceImageUrl() {
        return sourceImageUrl;
    }

    public void setSourceImageUrl(String sourceImageUrl) {
        this.sourceImageUrl = sourceImageUrl;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(Long chapterCount) {
        this.chapterCount = chapterCount;
    }

    public Long getWordCount() {
        return wordCount;
    }

    public void setWordCount(Long wordCount) {
        this.wordCount = wordCount;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getLastChapterName() {
        return lastChapterName;
    }

    public void setLastChapterName(String lastChapterName) {
        this.lastChapterName = lastChapterName;
    }
}
