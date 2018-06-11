package com.kee.sptringbootmastergradle.moudle.wechat.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeChatPayAPIServiceTest {

    @Autowired
    WeChatPayAPIService weChatPayAPIService;
    @Test
    public void unifiedorder() {
        weChatPayAPIService.unifiedorder();
    }
}