## springboot-mybatis-plus

- 用BaseMapper和IService实现自带的增删改查功能，并自定义了一个查询功能
- 学习mybatis-plus的Id策略（自增、雪花等）
- 逻辑删除（添加is_deleted字段）
- 乐观锁，给属性添加@Version注解来使用乐观锁避免冲突
- 条件构造器，方便地构造带条件的sql语句