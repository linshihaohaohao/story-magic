package org.yoqu.backend.engine;

import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.yoqu.common.entity.Chapter;
import org.yoqu.common.entity.Story;
import org.yoqu.common.enums.DragRuleTypeEnum;
import org.yoqu.common.utils.ContentStringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoqu on 17-5-31.
 */
@Component
public class SoduEngineProcessor implements PageProcessor {


    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);


    @Override
    public void process(Page page) {
        Request request = page.getRequest();
        String type = (String) request.getExtra("type");
        if (type != null) {
            if (type.equals("search")) {
                searchRule(page);
            } else if (type.equals("repository")) {
                bookRepositoryRule(page, request);
            } else if (type.equals("chapters")) {
                chapterRule(page, request);
            } else if (type.equals("content")) {
                contentRule(page, request);
            }
        } else {
            page.putField("result", false);
        }
    }


    private void contentRule(Page page, Request request) {
        String contentRule = (String) request.getExtra("contentRule");
        String ruleType = (String) request.getExtra("ruleType");
        String content = "";
        //判断操作类型
        if (ruleType.equals(DragRuleTypeEnum.XPATH.getValue())) {
            content = page.getHtml().xpath(contentRule).toString();
        } else if (ruleType.equals(DragRuleTypeEnum.JQUERY.getValue())) {
            content = page.getHtml().$(contentRule).toString();
        } else if (ruleType.equals(DragRuleTypeEnum.CSS.getValue())) {
            content = page.getHtml().css(contentRule).toString();
        } else if (ruleType.equals(DragRuleTypeEnum.REGEX.getValue())) {
            content = page.getHtml().regex(contentRule).toString();
        } else {
            content = page.getHtml().xpath(contentRule).toString();
        }
        //最后处理一下获取到的内容的html标签。
        content = ContentStringUtils.filterDivTag(content);
        page.putField("content", content);
    }

    /**
     * 章节规则
     *
     * @param page
     * @param request
     */
    private void chapterRule(Page page, Request request) {
        List<Selectable> trLists = page.getHtml().xpath("/html/body/table[4]/tbody/tr/td[1]/table/tbody/tr").nodes();
        List<Chapter> chapters = new ArrayList<>();
        //循环每个tr
        for (Selectable tr : trLists) {
            List<Selectable> tdList = tr.xpath("//td").nodes();
            //循环每个章节
            for (Selectable item : tdList) {
                Chapter chapter = new Chapter();
                String url = item.links().toString();
                String name = item.xpath("//a/text()").toString();
                //如果没有取到名字直接诶跳过即可
                if (StringUtils.isEmpty(name)) {
                    continue;
                }
                chapter.setName(name);
                chapter.setReadUrl(url);
                chapters.add(chapter);
            }
        }
        page.putField("chapters", chapters);
    }

    /**
     * 小说源匹配
     *
     * @param page
     * @param request
     */
    private void bookRepositoryRule(Page page, Request request) {
        List<Selectable> selectableList = page.getHtml().xpath("/html/body/div[@class='main-html']").nodes();
        List<Story> storyList = new ArrayList<>();
        for (Selectable s : selectableList) {
            String chapterName = s.xpath("//div/div[1]/a/text()").toString();
            String bookUrl = s.xpath("//div/div[1]").links().toString();
            String resourceSite = s.xpath("div/div[2]/a/text()").toString();
            String resourceSiteUrl = s.xpath("div/div[2]/a").links().toString();
            String lastDate = s.xpath("//div/div[3]/text()").toString();
            Story story = new Story();
            story.setBookUrl(bookUrl);
            story.setResourceSite(resourceSite);
            story.setResourceSiteUrl(resourceSiteUrl);
            story.setNewChapter(chapterName);
            story.setName(request.getExtra("bookName").toString());
            story.setLastUpdateDate(DateUtils.parseDate(lastDate));
            storyList.add(story);
        }
        page.putField("stories", storyList);
    }

    /**
     * 搜索规则
     *
     * @param page
     */
    private void searchRule(Page page) {
        List<Selectable> stories = page.getHtml().xpath("/html/body/div[@class='main-html']").nodes();
        List<Story> storyList = new ArrayList<>();
        for (Selectable s : stories) {
            String url = s.links().toString();
            String name = s.$("a", "text").toString();
            Story story = new Story();
            story.setName(name);
            story.setBookUrl(url);
            storyList.add(story);
        }
        page.putField("stories", storyList);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
