package org.yoqu.backend.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.yoqu.backend.config.SpiderProperties;
import org.yoqu.common.enums.DragRuleTypeEnum;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 * @author yoqu
 * @date 2017年06月19日
 * @time 下午2:11
 * @email wcjiang2@iflytek.com
 */

public abstract class CommonProcessor  implements PageProcessor {

    @Autowired
    SpiderProperties spiderProperties;

    static Selectable dragData(DragRuleTypeEnum ruleTypeEnum, Selectable page, String rule){
        Selectable result = null;
        if (ruleTypeEnum == DragRuleTypeEnum.XPATH){
            result = page.xpath(rule);
        }else if(ruleTypeEnum == DragRuleTypeEnum.CSS){
            result = page.css(rule);
        }else if(ruleTypeEnum == DragRuleTypeEnum.JQUERY){
            result = page.$(rule);
        }else if(ruleTypeEnum == DragRuleTypeEnum.REGEX){
            result = page.regex(rule);
        }else{
            result = page.xpath(rule);
        }
        return result;
    }

    static String  dragDataStr(DragRuleTypeEnum ruleTypeEnum, Selectable page, String rule){
        return CommonProcessor.dragData(ruleTypeEnum, page, rule).toString();
    }


    @Override
    public abstract void process(Page page) ;

    @Override
    public Site getSite() {
        return Site.me().setRetryTimes(spiderProperties.getRetryTime()).setSleepTime(spiderProperties.getSleepTime().intValue()).setTimeOut(spiderProperties.getTimeOut().intValue());
    }
}
