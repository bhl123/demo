package com.bhl.demo.BLL.controller;




import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bhl.demo.BLL.Utils.MyResponse;
import com.bhl.demo.BLL.model.User;
import com.bhl.demo.BLL.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("loginUser")
    public MyResponse loginUser(@RequestBody User user){
        System.out.println("~~~~");
        return loginService.loginUser(user);
    }

    @PostMapping("page")
    public MyResponse selectPage(){
        IPage<User> page = new Page<>(1, 2);
        return loginService.selectPage(page);

    }
}
