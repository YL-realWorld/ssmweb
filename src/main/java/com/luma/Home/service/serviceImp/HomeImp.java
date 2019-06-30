package com.luma.Home.service.serviceImp;

import com.luma.Common.pojos.Users;
import com.luma.Common.utils.ViewException;
import com.luma.Home.dao.HomeDao;
import com.luma.Home.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HomeService")
//@Transactional
public class HomeImp implements HomeService {
    @Autowired
    private HomeDao homeDao;

    @Override
    public Users getUserByNameAndPwd(String uname, String upass) {
        List<Users> myUser = homeDao.getUserByNameAndPwd(uname, upass);
        return myUser.size() == 1 ? (Users)myUser.get(0) : null;
    }

    @Override
    public void insertUser(Users user) {
        //TODO 新用户入库，并校验用户名是否已存在
        Users isExistUser = homeDao.getUserByUserName(user.getUname());
        if (null == isExistUser){
            homeDao.insert(user);
        } else {
            throw new ViewException("");
        }
    }
}
