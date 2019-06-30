package com.luma.Home.dao;

import com.luma.Common.pojos.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Repository
public interface HomeDao {

    //用户登录验证
    public List<Users> getUserByNameAndPwd(@Param(value = "uname") String uname, @Param(value = "upass") String upass);

    //通过用户名来查询当前用户名是否已存在
    Users getUserByUserName(String uname);

    //插入新的用户
    void insert(Users users);

    //更新用户信息
    void update(Users users);

    //通过ID删除用户
    void delete(int id);

    //TODO 用户的安全策略是否需要重新设计一张表？比如旧密码的历史保存次数
}