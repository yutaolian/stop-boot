# stop-boot
一站式的前后端开发框架(目标是从后台一直到app都通过代码自动生成)

TODO
    
    1.微信服务号管理
    2.微信，支付宝支付
    


1.mysql 公共字段生成sql 

```
alter table 表名 add 字段名 字段类型 DEFAULT NULL COMMENT '注释';
alter table menu add id int(11) NOT NULL AUTO_INCREMENT;
alter table menu add create_time datetime DEFAULT NULL COMMENT '创建时间';
alter table menu add update_time datetime DEFAULT NULL COMMENT '更新时间';
alter table menu add op_user_id int(11) DEFAULT NULL COMMENT '操作者id';
alter table menu add status int(2) DEFAULT NULL COMMENT '状态（1正常使用，0不使用）';
alter table menu add delete_flag int(2) DEFAULT NULL COMMENT '删除标识（0删除，1未删除）';
      
```


2.2019-09-19 

    1.支持多数据源
    2.Aop 做数据源动态切换，日志打印
    3.service基类优化
    4.springutils bean属性拷贝
    5.fastjson 统一处理返回结果
    6.统一异常处理
    7.请求参数根据方法统一设置
    8.router 接口生成

3.2019-09-24

    1.支持mybatis生成xml 自定义sqlxml
    2.自定义统一分页结果 PageResult 
    3.自定义统一返回结果及相应结果code msg等
    
4.2019-10-11

    1.添加基础缓存方法
