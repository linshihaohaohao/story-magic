package org.yoqu.backend.engine;

import org.apache.http.client.utils.DateUtils;
import org.assertj.core.util.DateUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.yoqu.common.entity.Chapter;
import org.yoqu.common.entity.Story;
import org.yoqu.common.entity.StoryResource;
import org.yoqu.common.entity.StoryResourceContent;
import org.yoqu.common.entity.rule.StoryRulePo;
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
        StoryRulePo storyRulePo = (StoryRulePo) request.getExtra("storyRulePo");
        String type = storyRulePo.getType();
        if (type != null) {
            if (type.equals("search")) {
                searchRule(page, storyRulePo);
            } else if (type.equals("repository")) {
                bookRepositoryRule(page, request, storyRulePo);
            } else if (type.equals("chapter")) {
                chapterRule(page, request,storyRulePo);
            } else if (type.equals("content")) {
                contentRule(page, request,storyRulePo);
            }
        } else {
            page.putField("result", false);
        }
    }


    private void contentRule(Page page, Request request,StoryRulePo storyRulePo) {
        String content = page.getHtml().xpath(storyRulePo.getStoryContentRulePo().getContentRule()).toString();
        String chapterName = page.getHtml().xpath(storyRulePo.getChapterName()).toString();
        content = ContentStringUtils.filterDivTag(content);
        Chapter chapter = new Chapter();
        chapter.setName(chapterName);
        chapter.setWordCount(Long.valueOf(content.length()));
        chapter.setContent(content);
        page.putField("chapter", chapter);
    }

    /**
     * 章节规则
     *
     * @param page
     * @param request
     */
    private void chapterRule(Page page, Request request,StoryRulePo storyRulePo) {
        if(request.getExtra("isChapterList").equals("true")){
            String bookName = page.getHtml().xpath(storyRulePo.getBookName()).toString();
            String authorName = page.getHtml().xpath(storyRulePo.getAuthorName()).toString();
            String imgUrl = page.getHtml().xpath(storyRulePo.getAlbumUrl()).toString();
            String bookDescription = page.getHtml().xpath(storyRulePo.getBookDescription()).toString();
            String lastUpdateDate = page.getHtml().xpath(storyRulePo.getLastUpdateRule()).toString();
            List<Selectable> chapterListTable = page.getHtml().xpath(storyRulePo.getListRule()).nodes();
            Story story = new Story();
            story.setName(bookName);
            story.setAuthor(authorName);
            story.setBookUrl(request.getUrl());
            story.setAlbumUrl(imgUrl);
            story.setLastUpdateDate(DateUtil.parse(lastUpdateDate));
            story.setDescription(bookDescription);
            List<Chapter> chapters = new ArrayList<>();
            for (Selectable s:chapterListTable) {
                String url = s.xpath(storyRulePo.getUrlRule()).links().toString();
                String chapterName = s.xpath(storyRulePo.getChapterName()).toString();
                Chapter chapter = new Chapter();
                chapter.setName(chapterName);
                chapter.setReadUrl(url);
                chapters.add(chapter);
            }
            story.setChapters(chapters);
            page.putField("book",story);
        }else{
            request.putExtra("isChapterList","true");
            String chapterUrl = page.getHtml().xpath(storyRulePo.getStoryChapterRulePo().getChapterListPageRule()).links().toString();
            request.setUrl(chapterUrl);
            page.addTargetRequest(request);
        }
    }

    /**
     * 小说源匹配
     *
     * @param page
     * @param request
     */
    private void bookRepositoryRule(Page page, Request request, StoryRulePo storyRulePo) {
        List<Selectable> selectableList = page.getHtml().xpath(storyRulePo.getListRule()).nodes();
        StoryResource storyResource = new StoryResource();
        List<StoryResourceContent> resourceContents = new ArrayList<>();
        boolean isInitflag = false;
        for (Selectable s : selectableList) {
            String chapterName = s.xpath(storyRulePo.getChapterName()).toString();
            String bookUrl = s.xpath(storyRulePo.getUrlRule()).links().toString();
            String resourceSite = s.xpath(storyRulePo.getResourceSiteRule()).toString();
            bookUrl=bookUrl.substring(bookUrl.lastIndexOf("http"));
            String lastDate = s.xpath(storyRulePo.getLastUpdateRule()).toString();
            //默认取第一个为默认源
            if (!isInitflag) {
                Chapter chapter = new Chapter();
                chapter.setReadUrl(bookUrl);
                chapter.setName(chapterName);
                chapter.setStatus(1);
                chapter.setUpdateDate(DateUtils.parseDate(lastDate));
                storyResource.setLastChapter(chapter);
                isInitflag = true;
                storyResource.setUrl(bookUrl);
                storyResource.setBookName(request.getExtra("bookName").toString());
                storyResource.setHost(resourceSite);
            } else {
                StoryResourceContent storyResourceContent = new StoryResourceContent();
                storyResourceContent.setHost(resourceSite);
                storyResourceContent.setUrl(bookUrl);
                storyResourceContent.setBookName(request.getExtra("bookName").toString());
                storyResourceContent.setLastChapterName(chapterName);
                resourceContents.add(storyResourceContent);
            }
        }
        storyResource.setStoryResourceContents(resourceContents);
        page.putField("stories", storyResource);
    }

    /**
     * 搜索规则
     *
     * @param page
     */
    private void searchRule(Page page, StoryRulePo storyRulePo) {
        List<Selectable> stories = page.getHtml().xpath(storyRulePo.getListRule()).nodes();//"/html/body/div[@class='main-html']").nodes();
        List<Story> storyList = new ArrayList<>();
        for (Selectable s : stories) {
            String url = s.links().toString();
            String name = s.xpath(storyRulePo.getBookName()).toString();
            String chapterName = s.xpath(storyRulePo.getChapterName()).toString();
            Story story = new Story();
            story.setName(name);
            story.setNewChapter(chapterName);
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
