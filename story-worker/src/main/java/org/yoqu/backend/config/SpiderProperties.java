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
    private Integer thread=5;

    /**
     * 重试次数
     */
    private Integer retryTime=3;

    /**
     * 休眠时间
     */
    private Long sleepTime=1000L;

    /**
     * 超时时间
     */
    private Long timeOut=20000L;

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

    public Long getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }
}
