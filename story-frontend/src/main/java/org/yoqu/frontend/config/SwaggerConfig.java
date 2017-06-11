package org.yoqu.frontend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/11
 * @time 18:15
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(or(regex("/api/.*")))
                .build()
                .apiInfo(storyApiInfo());
    }

    /**
     * 接口介绍
     * @return
     */
    private ApiInfo storyApiInfo() {
        return new ApiInfoBuilder()
                .title("小说接口文档")//大标题
                .description("小说的接口文档说明")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("yoqu", "http://www.yoqu.org", "yoqulin@qq.com"))//作者
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
