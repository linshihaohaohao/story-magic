package org.yoqu.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yoqu
 * @date 2017年06月03日
 * @time 下午11:18
 * @email wcjiang2@iflytek.com
 */
@ConfigurationProperties(prefix = "spider.config")
public class SpiderProperties {

    /**
     * 线程
     */
    private Integer thread;

    /**
     * 重试次数
     */
    private Integer retryTime;

    public Integer getThread() {
        return thread;
    }

    public void setThread(Integer thread) {
        this.thread = thread;
    }

    public Integer getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(Integer retryTime) {
        this.retryTime = retryTime;
    }
}
