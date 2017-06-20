package org.yoqu.story.admin.controller;

import org.hsweb.web.core.authorize.annotation.Authorize;
import org.hsweb.web.core.exception.NotFoundException;
import org.hsweb.web.core.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yoqu.common.entity.rule.StoryChapterRulePo;
import org.yoqu.common.entity.rule.StoryContentRulePo;
import org.yoqu.common.entity.rule.StorySiteRulePo;
import org.yoqu.story.dao.service.StoryChapterRuleService;
import org.yoqu.story.dao.service.StoryContentRuleService;
import org.yoqu.story.dao.service.StorySiteRuleService;

/**
 * Created by Admin on 2017/6/14.
 */
@Controller
@RequestMapping("/site/story")
public class StoryController {

    @Autowired
    private StorySiteRuleService storySiteRuleService;

    @Autowired
    private StoryContentRuleService storyContentRuleService;

    @RequestMapping(value = {"/", "/list.html"})
    @Authorize
    public ModelAndView index() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("absPath", WebUtil.getBasePath(WebUtil.getHttpServletRequest()));
        return modelAndView;
    }

    @RequestMapping(value = {"/save.html"})
    @Authorize
    public ModelAndView save(@RequestParam(value = "id",required = false) String id ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("absPath", WebUtil.getBasePath(WebUtil.getHttpServletRequest()));
        StorySiteRulePo storySiteRulePo = storySiteRuleService.selectByPk(id);
        if(null != id && null == storySiteRulePo){
            throw new NotFoundException("data is not found!");
        }
        modelAndView.addObject("param",storySiteRulePo == null?null:storySiteRulePo.getId());
        return modelAndView;
    }

    @RequestMapping(value = {"/content/save.html"})
    @Authorize
    public ModelAndView storyContent(@RequestParam(value = "id",required = false) String id ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("absPath", WebUtil.getBasePath(WebUtil.getHttpServletRequest()));
        StoryContentRulePo storyContentRulePo = null;
        if(null != id){
            storyContentRulePo =  storyContentRuleService.selectByPk(id);
//            throw new NotFoundException("data is not found!");
        }
        modelAndView.addObject("param",storyContentRulePo == null?null:storyContentRulePo.getId());
        return modelAndView;
    }

}
