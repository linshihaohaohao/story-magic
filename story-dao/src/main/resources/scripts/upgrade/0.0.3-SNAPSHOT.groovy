//package scripts.upgrade
//
//import org.hsweb.ezorm.rdb.RDBDatabase
//
//import java.sql.JDBCType
//
///**
// * Created by Admin on 2017/6/9.
// */
//
//    RDBDatabase db = database;
//        db.createOrAlter("story_story_site_rule")
//        .addColumn().name("id").alias("id").comment("ID").jdbcType(JDBCType.VARCHAR).length(128).primaryKey().commit()
//        .addColumn().name("name").alias("name").comment("名称").jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("url").alias("url").comment("地址").jdbcType(JDBCType.VARCHAR).length(255).commit()
//        .addColumn().name("type").alias("type").comment("网站类型"). jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("create_by").alias("create_by").comment("创建者").jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("create_date").alias("create_date").comment("创建时间").jdbcType(JDBCType.TIMESTAMP).length(0).commit()
//        .addColumn().name("update_by").alias("update_by").comment("编辑者").jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("chapter_name").alias("chapter_name").comment("章节名称").jdbcType(JDBCType.VARCHAR).length(255).commit()
//        .addColumn().name("update_date").alias("update_date").comment("编辑时间").jdbcType(JDBCType.TIMESTAMP).length(0).commit()
//        .addColumn().name("delete_flag").alias("delete_flag").comment("删除标签").jdbcType(JDBCType.BOOLEAN).length(2).commit()
//        .commit();
//
//db.getTable("story_story_site_rule")
//        .createInsert()
//        .value(["id"         : "92fda67abb81d6a6d5e2243382ce12eb", "name": "Sodu",
//                "url"        : "http://www.sodu.cc",
//                "create_by" : "admin",
//                "create_date" : new Date(),
//                "delete_flag": 0])
//        .exec();
//
//
//db.createOrAlter("story_story_rule")
//        .addColumn().name("id").alias("id").comment("ID").jdbcType(JDBCType.VARCHAR).length(128).primaryKey().commit()
//        .addColumn().name("name").alias("name").comment("名称").jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("book_name").alias("book_name").comment("书名").jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("author_name").alias("author_name").comment("作者").jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("type").alias("type").comment("类型").jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("list_rule").alias("list_rule").comment("列表规则").jdbcType(JDBCType.VARCHAR).length(255).commit()
//        .addColumn().name("url").alias("url").comment("地址").jdbcType(JDBCType.VARCHAR).length(255).commit()
//        .addColumn().name("create_by").alias("create_by").comment("创建者").jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("create_date").alias("create_date").comment("创建时间").jdbcType(JDBCType.TIMESTAMP).length(128).commit()
//        .addColumn().name("update_by").alias("update_by").comment("编辑者").jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("chapter_name").alias("chapter_name").comment("章节名称").jdbcType(JDBCType.VARCHAR).length(255).commit()
//        .addColumn().name("update_date").alias("update_date").comment("编辑时间").jdbcType(JDBCType.TIMESTAMP).length(128).commit()
//        .addColumn().name("delete_flag").alias("delete_flag").comment("删除标签").jdbcType(JDBCType.BOOLEAN).length(2).commit()
//        .addColumn().name("rule_type").alias("rule_type").comment("规则类型"). jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("album_url").alias("album_url").comment("小说封面"). jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("url_rule").alias("url_rule").comment("详情规则"). jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("resource_site_rule").alias("resource_site_rule").comment("资源网站名称规则"). jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("resource_site_url_rule").alias("resource_site_url_rule").comment("资源网站Url规则"). jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("last_update_date_rule").alias("last_update_date_rule").comment("最后更新时间获取规则"). jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .addColumn().name("story_site_rule_id").alias("story_site_rule_id").notNull().comment("站点ID"). jdbcType(JDBCType.VARCHAR).length(128).commit()
//        .commit();
//
//
//db.getTable("story_story_rule")
//        .createInsert()
//        .value(["id"         : "bfd6296a4f526ebb9683d7c94e2ba310", "name": "搜读搜索", "book_name": "//div[1]/a[1]/text()",
//                "author_name": "//div[2]/a[1]/text()", "type": "search", "list_rule": "/html/body/div[@class='main-html']",
//                "url"        : "http://www.sodu.cc/result.html?searchstr=",
//                "story_site_rule_id":"92fda67abb81d6a6d5e2243382ce12eb",
//                "delete_flag": 0])
//        .exec();
