package com.kee.sptringbootmastergradle.moudle.wechat.service;

import com.kee.sptringbootmastergradle.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

public class WeChatOAuthAPIServiceTest extends BaseTest {

    @Autowired
    WeChatOAuthAPIService weChatOAuthAPIService;

    @Test
    public void accessToken() {
    }

    @Test
    public void refreshToken() {
        String s = weChatOAuthAPIService.refreshToken();
        System.out.println(s);
    }

    @Test
    public void userInfo() {
    }
}