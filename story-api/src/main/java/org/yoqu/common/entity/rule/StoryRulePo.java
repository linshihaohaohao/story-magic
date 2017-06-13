package org.yoqu.common.entity.rule;

import org.hsweb.web.bean.po.GenericPo;

/**
 * Created by Kai on 2017/6/9.
 *
 * @Email zack.zhong@qq.com
 */
public class StoryRulePo extends BaseRulePo {

    /**
     * 规则名称
     */
    private String name;

    /**
     * 书籍名字规则
     */
    private String bookName;

    /**
     * 作者名字规则
     */
    private String authorName;

    /**
     * 类型
     */
    private String type;

    /**
     * 列表规则
     */
    private String listRule;

    /**
     * 章节名字规则
     */
    private String chapterName;

    /**
     * 网站url
     */
    private String url;

    /**
     * 详情规则
     */
    private String urlRule;

    /**
     * 资源网站名称规则
     */
    private String resourceSiteRule;

    /**
     * 资源网站Url规则
     */
    private String resourceSiteUrlRule;

    /**
     * 最后更新时间获取规则
     */
    private String lastUpdateRule;

    public String getLastUpdateRule() {
        return lastUpdateRule;
    }

    public void setLastUpdateRule(String lastUpdateRule) {
        this.lastUpdateRule = lastUpdateRule;
    }

    public String getResourceSiteRule() {
        return resourceSiteRule;
    }

    public void setResourceSiteRule(String resourceSiteRule) {
        this.resourceSiteRule = resourceSiteRule;
    }

    public String getResourceSiteUrlRule() {
        return resourceSiteUrlRule;
    }

    public void setResourceSiteUrlRule(String resourceSiteUrlRule) {
        this.resourceSiteUrlRule = resourceSiteUrlRule;
    }

    public String getUrlRule() {
        return urlRule;
    }

    public void setUrlRule(String urlRule) {
        this.urlRule = urlRule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getListRule() {
        return listRule;
    }

    public void setListRule(String listRule) {
        this.listRule = listRule;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public interface Property extends GenericPo.Property {

        String name = "name";

        String bookName = "bookName";

        String authorName = "authorName";

        String type = "type";

        String listRule = "listRule";

        String chapterName = "chapterName";

        String url = "url";
    }

}
