package com.bhl.demo.BLL.service;


import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bhl.demo.BLL.Utils.MyResponse;
import com.bhl.demo.BLL.mapper.LoginMapper;
import com.bhl.demo.BLL.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public MyResponse loginUser(User user) {
        MyResponse myResponse = new MyResponse();
        myResponse.setCode(20000);
        myResponse.setCodeMsg("操作成功");
        myResponse.setData(user);
        loginMapper.loginUser(user);
        return myResponse;
    }

    public MyResponse selectPage(IPage<User> page) {
        MyResponse myResponse = new MyResponse();
        myResponse.setCode(20000);
        myResponse.setCodeMsg("success");
        //List<User> users = loginMapper.selectUserList(page);
//        loginMapper.selectPage(page,null);

//        myResponse.setData(loginMapper.selectById("1"));
        IPage<User> list = loginMapper.selectPage(page,null);
        myResponse.setData(list);
        return myResponse;
    }
}
