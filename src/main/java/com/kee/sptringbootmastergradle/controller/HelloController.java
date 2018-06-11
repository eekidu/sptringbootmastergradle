package com.kee.sptringbootmastergradle.controller;

import com.kee.sptringbootmastergradle.utils.net.resultpojo.ErrorTypeEnum;
import com.kee.sptringbootmastergradle.utils.net.resultpojo.ResultJsonBean;
import com.kee.sptringbootmastergradle.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/hello")
    public ResultJsonBean hello() {

        User user = new User();
        user.setId(10);
        user.setName("caohiakudddaeeenddd");
//        return ResultJsonBean.returnOK(user);
        return ResultJsonBean.returnError(ErrorTypeEnum.PARAMES_ERR, "用户id不能为空").addExtraInfo("userid", "1079");
    }

    @RequestMapping("/tryerror")
    public ResultJsonBean tryError() {
        int a = 1 / 0;
        return ResultJsonBean.returnOK();
    }

    @RequestMapping("/tryapierror")
    public ResultJsonBean tryApiError() {
        int a = 1 / 0;
        return ResultJsonBean.returnOK();
    }

}
