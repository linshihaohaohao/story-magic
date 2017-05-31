package org.yoqu.engine;

import org.apache.http.client.utils.DateUtils;
import org.yoqu.story.entity.Story;
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
                bookRepositoryRule(page,request);
            }
        } else {
            page.putField("result", false);
        }
    }

    /**
     * 小说源匹配
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
            String lastDate = s.xpath("//div/div[3]/text()").toString();
            Story story = new Story();
            story.setBookUrl(bookUrl);
            story.setResourceSite(resourceSite);
            story.setNewChapter(chapterName);
            story.setName(request.getExtra("bookName").toString());
            story.setLastUpdateDate(DateUtils.parseDate(lastDate));
            storyList.add(story);
        }
        page.putField("stories",storyList);
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
