

import org.hsweb.ezorm.rdb.RDBDatabase

import java.sql.JDBCType

RDBDatabase db = database;
db.createOrAlter("story_story_rule")
    .addColumn().name("id").alias("id").comment("ID").jdbcType(JDBCType.VARCHAR).length(128).primaryKey().commit()
    .addColumn().name("name").alias("name").comment("名称").jdbcType(JDBCType.VARCHAR).length(128).commit()
    .addColumn().name("book_name").alias("book_name").comment("书名").jdbcType(JDBCType.VARCHAR).length(128).commit()
            .addColumn().name("author_name").alias("author_name").comment("作者").jdbcType(JDBCType.VARCHAR).length(128).commit()
            .addColumn().name("type").alias("type").comment("类型").jdbcType(JDBCType.VARCHAR).length(128).commit()
            .addColumn().name("list_rule").alias("list_rule").comment("列表规则").jdbcType(JDBCType.VARCHAR).length(255).commit()
            .addColumn().name("url").alias("url").comment("地址").jdbcType(JDBCType.VARCHAR).length(255).commit()
            .addColumn().name("create_by").alias("create_by").comment("创建者").jdbcType(JDBCType.VARCHAR).length(128).commit()
            .addColumn().name("create_date").alias("create_date").comment("创建时间").jdbcType(JDBCType.TIMESTAMP).length(128).commit()
            .addColumn().name("update_by").alias("update_by").comment("编辑者").jdbcType(JDBCType.VARCHAR).length(128).commit()
            .addColumn().name("update_date").alias("update_date").comment("编辑时间").jdbcType(JDBCType.TIMESTAMP).length(128).commit()
            .addColumn().name("delete_flag").alias("delete_flag").comment("删除标签").jdbcType(JDBCType.BOOLEAN).length(2).commit()
    .commit();

