package org.yoqu.story.dao.config;

/**
 * Created by Admin on 2017/6/10.
 */
import org.hsweb.web.mybatis.MyBatisAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.yoqu.story.dao"})
@MapperScan(basePackages = {"org.yoqu.story.dao"})
@AutoConfigureAfter(MyBatisAutoConfiguration.class)
@EnableConfigurationProperties(StoryMybatisProperties.class)
public class StoryDaoAutoConfiguration  extends MyBatisAutoConfiguration {
}