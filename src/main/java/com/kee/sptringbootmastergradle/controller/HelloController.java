package com.kee.sptringbootmastergradle.controller;

import com.kee.sptringbootmastergradle.entity.ResultJsonBean;
import com.kee.sptringbootmastergradle.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/hello")
    public ResultJsonBean hello() {
        User user=new User();
        user.setId(10);
        user.setName("caohiakudddanddd");
        return ResultJsonBean.returnOK(user);
//        return user;
    }
}
