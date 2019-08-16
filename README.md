# stop-boot
一站式的前后端开发框架(目标是从后台一直到app都通过代码自动生成)


1.mysql 公共字段生成sql 

     alter table 表名 add 字段名 字段类型 DEFAULT NULL COMMENT '注释';
   
   ```
      alter table menu add id int(11) NOT NULL AUTO_INCREMENT;
      alter table menu add create_time datetime DEFAULT NULL COMMENT '创建时间';
      alter table menu add update_time datetime DEFAULT NULL COMMENT '更新时间';
      alter table menu add op_user_id int(11) DEFAULT NULL COMMENT '操作者id';
      alter table menu add status int(2) DEFAULT NULL COMMENT '状态（1正常使用，0不使用）';
      alter table menu add delete_flag int(2) DEFAULT NULL COMMENT '删除标识（0删除，1未删除）';
      
    ```
