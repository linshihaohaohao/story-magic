package org.yoqu.story.dao.config;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Admin on 2017/6/10.
 */
public class StoryMybatisProperties extends org.mybatis.spring.boot.autoconfigure.MybatisProperties {
    private static final String defaultMapperLocation = "classpath*:org/yoqu/story/dao/impl/mybatis/mapper/*.xml";
    private boolean dynamicDatasource = false;
    private String[] mapperLocationExcludes = null;

    public StoryMybatisProperties() {
    }

    public String[] getMapperLocationExcludes() {
        return this.mapperLocationExcludes;
    }

    public void setMapperLocationExcludes(String[] mapperLocationExcludes) {
        this.mapperLocationExcludes = mapperLocationExcludes;
    }

    public boolean isDynamicDatasource() {
        return this.dynamicDatasource;
    }

    public void setDynamicDatasource(boolean dynamicDatasource) {
        this.dynamicDatasource = dynamicDatasource;
    }

    public Resource[] resolveMapperLocations() {
        Map<String, Resource> resources = new HashMap();
        Object locations;
        if(this.getMapperLocations() == null) {
            locations = new HashSet();
        } else {
            locations = (Set) Arrays.stream(this.getMapperLocations()).collect(Collectors.toSet());
        }

        ((Set)locations).add(defaultMapperLocation);
        Iterator var3 = ((Set)locations).iterator();

        while(var3.hasNext()) {
            String mapperLocation = (String)var3.next();

            try {
                Resource[] mappers = (new PathMatchingResourcePatternResolver()).getResources(mapperLocation);
                Resource[] var6 = mappers;
                int var7 = mappers.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    Resource mapper = var6[var8];
                    resources.put(mapper.getURL().toString(), mapper);
                }
            } catch (IOException var13) {
            }
        }

        if(this.mapperLocationExcludes != null && this.mapperLocationExcludes.length > 0) {
            String[] var14 = this.mapperLocationExcludes;
            int var16 = var14.length;

            for(int var17 = 0; var17 < var16; ++var17) {
                String mapperLocationExclude = var14[var17];

                try {
                    Resource[] excludesMappers = (new PathMatchingResourcePatternResolver()).getResources(mapperLocationExclude);
                    Resource[] var20 = excludesMappers;
                    int var21 = excludesMappers.length;

                    for(int var10 = 0; var10 < var21; ++var10) {
                        Resource excludesMapper = var20[var10];
                        resources.remove(excludesMapper.getURL().toString());
                    }
                } catch (IOException var12) {
                    ;
                }
            }
        }

        Resource[] mapperLocations = new Resource[resources.size()];
        mapperLocations = (Resource[])resources.values().toArray(mapperLocations);
        return mapperLocations;
    }
}
