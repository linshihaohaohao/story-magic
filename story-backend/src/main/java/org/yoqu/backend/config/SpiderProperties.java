package org.yoqu.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author yoqu
 * @date 2017年06月03日
 * @time 下午11:18
 * @email wcjiang2@iflytek.com
 */
@ConfigurationProperties(prefix = "spider")
public class SpiderProperties {

    /**
     * 线程
     */
    private int thread;

    /**
     * 重试次数
     */
    private int retryTime;

    public int getThread() {
        return thread;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }

    public int getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(int retryTime) {
        this.retryTime = retryTime;
    }
}
