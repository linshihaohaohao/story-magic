package org.yoqu.story.dao;

import org.apache.ibatis.annotations.Mapper;
import org.hsweb.web.mybatis.MybatisProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/11
 * @time 15:01
 */
@Configuration
@MapperScan(value = "org.yoqu.story.dao.mappers",annotationClass = Mapper.class)
public class StoryDaoAutoConfiguration {
    //指定使用hsweb的properties，
    @Bean
    @Primary
    public MybatisProperties mybatisProperties() {
        return new MybatisProperties();
    }

}
