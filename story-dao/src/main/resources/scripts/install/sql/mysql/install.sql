SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for story_story_rule
-- ----------------------------
DROP TABLE IF EXISTS `story_story_rule`;
CREATE TABLE `story_story_rule` (
  `id` varchar(128) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `book_name` varchar(128) DEFAULT NULL,
  `book_description` varchar(256) DEFAULT NULL,
  `author_name` varchar(128) DEFAULT NULL,
  `type` varchar(128) DEFAULT NULL,
  `list_rule` varchar(255) DEFAULT NULL,
  `chapter_name` varchar(128) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `rule_type` varchar(255) DEFAULT NULL,
  `album_url` varchar(255) DEFAULT NULL,
  `url_rule` varchar(255) DEFAULT NULL,
  `resource_site_rule` varchar(255) DEFAULT NULL,
  `resource_site_url_rule` varchar(255) DEFAULT NULL,
  `last_update_date_rule` varchar(255) DEFAULT NULL,
  `story_site_rule_id` varchar(255) DEFAULT NULL,
  `create_by` varchar(128) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(128) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小说规则表';;

-- ----------------------------
-- Records of story_story_rule
-- ----------------------------
BEGIN;
INSERT INTO `story_story_rule` (`id`, `name`, `book_name`, `book_description`, `author_name`, `type`, `list_rule`, `chapter_name`, `url`, `rule_type`, `album_url`, `url_rule`, `resource_site_rule`, `resource_site_url_rule`, `last_update_date_rule`, `story_site_rule_id`, `create_by`, `create_date`, `update_by`, `update_date`, `delete_flag`) VALUES ('bfd6296a4f526ebb9683d7c94e2ba11a', '木哥鱼', NULL, NULL, NULL, 'content', NULL, '/html/body/div[@class=\'readerTitle\']/div[@id=\'yueduye\']/h1', 'http://www.muyuge.com/', 'XPATH', NULL, NULL, NULL, NULL, NULL, '92fda67abb81d6a6d5e2243382ce12eb', NULL, NULL, NULL, NULL, '0');
INSERT INTO `story_story_rule` (`id`, `name`, `book_name`, `book_description`, `author_name`, `type`, `list_rule`, `chapter_name`, `url`, `rule_type`, `album_url`, `url_rule`, `resource_site_rule`, `resource_site_url_rule`, `last_update_date_rule`, `story_site_rule_id`, `create_by`, `create_date`, `update_by`, `update_date`, `delete_flag`) VALUES ('bfd6296a4f526ebb9683d7c94e2ba310', '搜读搜索', '//div[1]/a[1]/text()', NULL, '//div[2]/a[1]/text()', 'search', '/html/body/div[@class=\'main-html\']', '', 'http://www.sodu.cc/result.html?searchstr=', 'XPATH', NULL, NULL, NULL, NULL, '', '92fda67abb81d6a6d5e2243382ce12eb', 'admin', '2017-06-14 20:39:31', NULL, NULL, '0');
INSERT INTO `story_story_rule` (`id`, `name`, `book_name`, `book_description`, `author_name`, `type`, `list_rule`, `chapter_name`, `url`, `rule_type`, `album_url`, `url_rule`, `resource_site_rule`, `resource_site_url_rule`, `last_update_date_rule`, `story_site_rule_id`, `create_by`, `create_date`, `update_by`, `update_date`, `delete_flag`) VALUES ('bfd6296a4f526ebb9683d7c94e2ba311', '搜读源', NULL, NULL, NULL, 'repository', '/html/body/div[@class=\'main-html\']', '//div/div[1]/a/text()', NULL, 'XPATH', NULL, '//div/div[1]', 'div/div[2]/a/text()', 'div/div[2]/a/text()', '//div/div[3]/text()', '92fda67abb81d6a6d5e2243382ce12eb', NULL, NULL, NULL, NULL, '0');
INSERT INTO `story_story_rule` (`id`, `name`, `book_name`, `book_description`, `author_name`, `type`, `list_rule`, `chapter_name`, `url`, `rule_type`, `album_url`, `url_rule`, `resource_site_rule`, `resource_site_url_rule`, `last_update_date_rule`, `story_site_rule_id`, `create_by`, `create_date`, `update_by`, `update_date`, `delete_flag`) VALUES ('bfd6296a4f526ebb9683d7c94e2ba312', '木哥鱼', '/html/body/div[@id=\'yueduye\']/div[@id=\'xsinfo\']/div[@class=\'xsh1\']/h1/a/text()', '/html/body/div[@id=\'yueduye\']/div[@id=\'xsinfo\']/div[@class=\'indexxx\']/div[@id=\'xsintro\']/p[5]/text()', '/html/body/div[@id=\'yueduye\']/div[@id=\'xsinfo\']/div[@class=\'xsh1\']/text()', 'chapter', '/html/body/div[@id=\'yueduye\']/div[@id=\'xslist\']/ul[1]/li', '//a/text()', 'http://www.muyuge.com/null', 'XPATH', '/html/body/div[@id=\'yueduye\']/div[@id=\'xsinfo\']/div[@class=\'indexxx\']/div[@id=\'xsintro\']/div[@id=\'fmimg\']/img/@src', '//a', NULL, NULL, '/html/body/div[@id=\'yueduye\']/div[@id=\'xsinfo\']/div[@class=\'indexxx\']/div[@id=\'xsintro\']/p[2]/span/strong/text()', '92fda67abb81d6a6d5e2243382ce12eb', NULL, NULL, NULL, NULL, '0');
COMMIT;

-- ----------------------------
-- Table structure for story_story_chapter_rule
-- ----------------------------
DROP TABLE IF EXISTS `story_story_chapter_rule`;
CREATE TABLE `story_story_chapter_rule` (
  `id` varchar(128) NOT NULL,
  `story_rule_id` varchar(128) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `chapter_list_page_rule` varchar(128) DEFAULT NULL COMMENT '链接到小说简介章节页面的规则',
  `create_by` varchar(128) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(128) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小说章节规则表';;

-- ----------------------------
-- Records of story_story_chapter_rule
-- ----------------------------
BEGIN;
INSERT INTO `story_story_chapter_rule` VALUES ('bfd6296a4f526ebb9683d7c94e2ba312a', 'bfd6296a4f526ebb9683d7c94e2ba312', '章节详情页', '/html/body/div[@class=\'readerHader\']/ul[@class=\'readerNav\']/li/a[3]', NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for story_story_content_rule
-- ----------------------------
DROP TABLE IF EXISTS `story_story_content_rule`;
CREATE TABLE `story_story_content_rule` (
  `id` varchar(128) NOT NULL,
  `story_rule_id` varchar(128) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `content_rule` varchar(256) DEFAULT NULL COMMENT '小说内容页',
  `create_by` varchar(128) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(128) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小说章节规则表';;

-- ----------------------------
-- Records of story_story_content_rule
-- ----------------------------
BEGIN;
INSERT INTO `story_story_content_rule` VALUES ('bfd6296a4f526ebb9683d7c94e2ba312a', 'bfd6296a4f526ebb9683d7c94e2ba11a', '章节详情页', '/html/body/div[@class=\'readerTitle\']/div[@id=\'yueduye\']/div[@class=\'readerContent\']/div[@id=\'content\']', NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for story_story_site_rule
-- ----------------------------
DROP TABLE IF EXISTS `story_story_site_rule`;
CREATE TABLE `story_story_site_rule` (
  `id` varchar(128) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `type` varchar(128) DEFAULT NULL,
  `create_by` varchar(128) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(128) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `delete_flag` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Records of story_story_site_rule
-- ----------------------------
BEGIN;
INSERT INTO `story_story_site_rule` VALUES ('92fda67abb81d6a6d5e2243382ce12eb', 'Sodu', 'http://www.sodu.cc', '小说', 'admin', '2017-06-18 22:22:56', NULL, '2017-06-18 22:22:56', 0);
COMMIT;

INSERT INTO `s_modules` VALUES ('story', '网站规则管理', '', 'icon-server-connect', '-1', '', '1', '[{\"id\":\"M\",\"text\":\"菜单可见\",\"checked\":true}]', '1');

INSERT INTO `s_modules` VALUES ('storyRule', '小说网站规则', 'site/story/list.html', 'icon-page-green', 'story', '', '1', '[{\"id\":\"M\",\"text\":\"菜单可见\"},{\"id\":\"C\",\"text\":\"新增\"},{\"id\":\"R\",\"text\":\"读取\"},{\"id\":\"U\",\"text\":\"更新\"},{\"id\":\"D\",\"text\":\"删除\"}]', '101');


SET FOREIGN_KEY_CHECKS = 1;