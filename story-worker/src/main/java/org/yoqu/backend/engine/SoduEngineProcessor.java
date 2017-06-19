package org.yoqu.backend.engine;

import org.apache.http.client.utils.DateUtils;
import org.assertj.core.util.DateUtil;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.yoqu.backend.config.SpiderProperties;
import org.yoqu.common.entity.Chapter;
import org.yoqu.common.entity.Story;
import org.yoqu.common.entity.StoryResource;
import org.yoqu.common.entity.StoryResourceContent;
import org.yoqu.common.entity.rule.StoryRulePo;
import org.yoqu.common.enums.StoryTypeEnum;
import org.yoqu.common.utils.ContentStringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoqu on 17-5-31.
 */
@Component
@EnableConfigurationProperties(SpiderProperties.class)
public class SoduEngineProcessor extends CommonProcessor {



    @Override
    public void process(Page page) {
        Request request = page.getRequest();
        StoryRulePo storyRulePo = (StoryRulePo) request.getExtra("storyRulePo");
        StoryTypeEnum type = storyRulePo.getType();
        if (type != null) {
            if (type.value().equals("search")) {
                searchRule(page, storyRulePo);
            } else if (type.value().equals("repository")) {
                bookRepositoryRule(page, request, storyRulePo);
            } else if (type.value().equals("chapter")) {
                chapterRule(page, request,storyRulePo);
            } else if (type.value().equals("content")) {
                contentRule(page, request,storyRulePo);
            }
        } else {
            page.putField("data", false);
        }
    }

    /**
     *
     * @param page
     * @param request
     * @param storyRulePo
     */
    private void contentRule(Page page, Request request,StoryRulePo storyRulePo) {
        String content = dragItem(storyRulePo,page,storyRulePo.getStoryContentRulePo().getContentRule());//dragDataStr(storyRulePo.getRuleType(),page.getHtml(),storyRulePo.getStoryContentRulePo().getContentRule());
        String chapterName = dragItem(storyRulePo,page,storyRulePo.getChapterName());//dragDataStr(storyRulePo.getRuleType(),page.getHtml(),storyRulePo.getChapterName());
        content = ContentStringUtils.filterDivTag(content);
        Chapter chapter = new Chapter();
        chapter.setName(chapterName);
        chapter.setWordCount(Long.valueOf(content.length()));
        chapter.setContent(content);
        page.putField("data", chapter);
    }

    /**
     * 抓取某个属性，如果规则为空则不抓
     * @param storyRulePo
     * @param page
     * @param rule
     * @return
     */
    public String dragItem(StoryRulePo storyRulePo,Page page,String rule){
        if(rule ==null){
            return null;
        }else{
            return dragDataStr(storyRulePo.getRuleType(),page.getHtml(),rule);
        }
    }

    /**
     * 抓取通用小说实体信息方法
     * @param page
     * @param request
     * @param storyRulePo
     * @return
     */
    private Story dragStoryCommonInfo(Page page, Request request,StoryRulePo storyRulePo){
        String bookName = dragItem(storyRulePo,page,storyRulePo.getBookName());
        String authorName = dragItem(storyRulePo,page,storyRulePo.getAuthorName());// dragDataStr(storyRulePo.getRuleType(),page.getHtml(),storyRulePo.getAuthorName()) ;//page.getHtml().xpath(storyRulePo.getAuthorName()).toString();
        String imgUrl = dragItem(storyRulePo,page,storyRulePo.getAlbumUrl());//dragDataStr(storyRulePo.getRuleType(),page.getHtml(),storyRulePo.getAlbumUrl()); page.getHtml().xpath(storyRulePo.getAlbumUrl()).toString();
        String bookDescription = dragItem(storyRulePo,page,storyRulePo.getBookDescription());//page.getHtml().xpath(storyRulePo.getBookDescription()).toString();
        String lastUpdateDate = dragItem(storyRulePo,page,storyRulePo.getLastUpdateRule());//page.getHtml().xpath(storyRulePo.getLastUpdateRule()).toString();
        Story story = new Story();
        story.setName(bookName);
        story.setAuthor(authorName);
        story.setBookUrl(request.getUrl());
        story.setAlbumUrl(imgUrl);
        story.setLastUpdateDate(DateUtil.parse(lastUpdateDate));
        story.setDescription(bookDescription);
        return story;
    }

    /**
     * 章节规则
     *
     * @param page
     * @param request
     */
    private void chapterRule(Page page, Request request,StoryRulePo storyRulePo) {
        if(request.getExtra("isChapterList").equals("true")){
           List<Selectable> chapterListTable = dragData(storyRulePo.getRuleType(),page.getHtml(),storyRulePo.getListRule()).nodes();
            Story story = dragStoryCommonInfo(page, request, storyRulePo);
            List<Chapter> chapters = new ArrayList<>();
            for (Selectable s:chapterListTable) {
                String url = dragData(storyRulePo.getRuleType(),s,storyRulePo.getUrlRule()).links().toString();
                String chapterName = dragDataStr(storyRulePo.getRuleType(),s,storyRulePo.getChapterName());
                Chapter chapter = new Chapter();
                chapter.setName(chapterName);
                chapter.setReadUrl(url);
                chapters.add(chapter);
            }
            story.setChapters(chapters);
            page.putField("data",story);
        }else{
            request.putExtra("isChapterList","true");
            String chapterUrl = dragData(storyRulePo.getRuleType(),page.getHtml(),storyRulePo.getStoryChapterRulePo()
                    .getChapterListPageRule()).links().toString();
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
        List<Selectable> selectableList = dragData(storyRulePo.getRuleType(),page.getHtml(),storyRulePo.getListRule()).nodes();
        StoryResource storyResource = new StoryResource();
        List<StoryResourceContent> resourceContents = new ArrayList<>();
        boolean isInitflag = false;
        for (Selectable s : selectableList) {
            String chapterName = dragDataStr(storyRulePo.getRuleType(),s,storyRulePo.getChapterName());
            String bookUrl = dragData(storyRulePo.getRuleType(),s,storyRulePo.getUrlRule()).links().toString();
            String resourceSite = dragDataStr(storyRulePo.getRuleType(),s,storyRulePo.getResourceSiteRule());
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
        page.putField("data", storyResource);
    }


    /**
     * 搜索规则
     *
     * @param page
     */
    private void searchRule(Page page, StoryRulePo storyRulePo) {
        List<Selectable> stories = dragData(storyRulePo.getRuleType(),page.getHtml(),storyRulePo.getListRule()).nodes();//page.getHtml().xpath(storyRulePo.getListRule()).nodes();//"/html/body/div[@class='main-html']").nodes();
        List<Story> storyList = new ArrayList<>();
        for (Selectable s : stories) {
            String url = s.links().toString();
            String name = dragDataStr(storyRulePo.getRuleType(),s,storyRulePo.getBookName());//s.xpath(storyRulePo.getBookName()).toString();
            String chapterName = dragDataStr(storyRulePo.getRuleType(),s,storyRulePo.getChapterName());//s.xpath(storyRulePo.getChapterName()).toString();
            Story story = new Story();
            story.setName(name);
            story.setNewChapter(chapterName);
            story.setBookUrl(url);
            storyList.add(story);
        }

        page.putField("data", storyList);
    }

}
