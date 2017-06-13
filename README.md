# 

`author` : [yoqu](http://www.yoqu.org)

`createTime` : 2017年06月02 下午4:47


---
# 爬虫简介

本项目主要用于学习爬虫知识搭建的项目，目标是做一个分布式多网站小说**智能**爬虫，动态提交爬取任务，单线管理，多ip终端防反扒（使用Eureka server 管理自服务的心跳连接）

目前正在初始开发中。完成后的功能主要有：
* 提供restful接口对外显示整个小说库的数据,需实现安全认证

* 提供一套界面用于管理爬取网站的规则

* 提供一套简易风格界面用于阅读小说

# 启动项目

 1. 下载项目到本地目录，使用idea导入本项目，并解决依赖问题
 2. 运行eureka-server 中的`EurekaServerApplication`的`main`方法
 3. 修改`story-admin`和`frontend`中的`application-dev.yml`文件中的数据库连接账号和密码
 4. 启动`story-admin`，项目第一次启动会往数据库中建立初始脚本
 5. 启动`story-worker`.
 6. 启动`story-frontend` 在浏览器输入http://localhost:3333/api/v1/search?name= ***填写搜索的书名***
    例如输入http://localhost:3333/api/v1/search?name=逆鳞
    返回的结果如下：
```json
       {
           "code": 200,
           "data": {
               "stories": [
                   {
                       "newChapter": "第七百一十八章、风再起时！【卓雅居全文字秒更】",
                       "resourceSite": null,
                       "chapters": null,
                       "author": null,
                       "lastUpdateDate": null,
                       "name": "逆鳞",
                       "id": null,
                       "bookUrl": "http://www.sodu.cc/mulu_26997.html",
                       "resourceSiteUrl": null
                   },
                   {
                       "newChapter": "第163章 化敌为友",
                       "resourceSite": null,
                       "chapters": null,
                       "author": null,
                       "lastUpdateDate": null,
                       "name": "逆鳞苍穹传",
                       "id": null,
                       "bookUrl": "http://www.sodu.cc/mulu_458710.html",
                       "resourceSiteUrl": null
                   },
                   {
                       "newChapter": "第四十七章 黑夜激斗",
                       "resourceSite": null,
                       "chapters": null,
                       "author": null,
                       "lastUpdateDate": null,
                       "name": "秦时明月之逆鳞变",
                       "id": null,
                       "bookUrl": "http://www.sodu.cc/mulu_453833.html",
                       "resourceSiteUrl": null
                   },
                   {
                       "newChapter": "卷 后记",
                       "resourceSite": null,
                       "chapters": null,
                       "author": null,
                       "lastUpdateDate": null,
                       "name": "魔剑逆鳞",
                       "id": null,
                       "bookUrl": "http://www.sodu.cc/mulu_154964.html",
                       "resourceSiteUrl": null
                   },
                   {
                       "newChapter": "第七章 永无止尽的战斗【卓雅居全文字秒更】",
                       "resourceSite": null,
                       "chapters": null,
                       "author": null,
                       "lastUpdateDate": null,
                       "name": "逆鳞传",
                       "id": null,
                       "bookUrl": "http://www.sodu.cc/mulu_259124.html",
                       "resourceSiteUrl": null
                   },
                   {
                       "newChapter": "【37】林天宇致命屠魔",
                       "resourceSite": null,
                       "chapters": null,
                       "author": null,
                       "lastUpdateDate": null,
                       "name": "逆鳞狂龙",
                       "id": null,
                       "bookUrl": "http://www.sodu.cc/mulu_454766.html",
                       "resourceSiteUrl": null
                   },
                   {
                       "newChapter": "第64章 龙九的逆鳞（终章）【卓雅居全文字秒更】",
                       "resourceSite": null,
                       "chapters": null,
                       "author": null,
                       "lastUpdateDate": null,
                       "name": "心炎-逆鳞",
                       "id": null,
                       "bookUrl": "http://www.sodu.cc/mulu_162633.html",
                       "resourceSiteUrl": null
                   },
                   {
                       "newChapter": "第三十七章 蒙面人【卓雅居全文字秒更】",
                       "resourceSite": null,
                       "chapters": null,
                       "author": null,
                       "lastUpdateDate": null,
                       "name": "逆鳞破天",
                       "id": null,
                       "bookUrl": "http://www.sodu.cc/mulu_29131.html",
                       "resourceSiteUrl": null
                   },
                   {
                       "newChapter": "第七十九章 血漫沙场 沈欢大战方圆阵【卓雅居全文字秒更】",
                       "resourceSite": null,
                       "chapters": null,
                       "author": null,
                       "lastUpdateDate": null,
                       "name": "龙之逆鳞",
                       "id": null,
                       "bookUrl": "http://www.sodu.cc/mulu_74632.html",
                       "resourceSiteUrl": null
                   },
                   {
                       "newChapter": "第64节藏书阁【卓雅居全文字秒更】",
                       "resourceSite": null,
                       "chapters": null,
                       "author": null,
                       "lastUpdateDate": null,
                       "name": "逆鳞龙女",
                       "id": null,
                       "bookUrl": "http://www.sodu.cc/mulu_110140.html",
                       "resourceSiteUrl": null
                   }
               ]
           },
           "message": null,
           "success": true
       }
```


# 程序交流

交流QQ群：**536747201**

# 使用技术栈

项目所选用的技术框架以及工具(包括但不限于)：
* java
* jdk1.8
* maven
* spring boot
* Spring Cloud
* Spring Cloud Eureka
* mysql
* redis
* webmagic

# 项目结构
## 目录结构
```
├── common-utils    公共工具类
├── eureka-server   服务注册发现中心，用于做多个worker集线管理
├── story-admin    后台管理界面，管理抓取规则等功能
├── story-api    公共api
├── story-dao    数据访问层
└── story-frontend  前端访问层，主要用于小说内容访问层
└── story-worker  小说抓取器，有关爬虫相关的操作均由worker去操作
```
## 系统架构

![小说架构图](document/小说爬虫架构图.png)