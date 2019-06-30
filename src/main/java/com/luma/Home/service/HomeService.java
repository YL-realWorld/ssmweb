package com.luma.Home.service;

import com.luma.Common.pojos.Users;

public interface HomeService {

    //用户登录验证
    public Users getUserByNameAndPwd(String uname, String upass);

    //插入用户
    void insertUser(Users user);

}
