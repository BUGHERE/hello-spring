package com.everywhere.springbootmybatis.dao;

import com.everywhere.springbootmybatis.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 通过名字查询用户信息
     *
     * @param name 用户姓名
     * @return 查询到的用户
     */
    List<User> findUserByName(@Param("name") String name);

    /**
     * 查询所有用户信息
     */
    List<User> findAllUser();

    /**
     * 插入用户信息
     *
     * @param name 姓名
     * @param age  年龄
     */
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money);

    /**
     * 根据 id 更新用户信息
     */
    void updateUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money,
                    @Param("id") int id);

    /**
     * 根据 id 删除用户信息
     */
    void deleteUser(@Param("id") int id);
}
