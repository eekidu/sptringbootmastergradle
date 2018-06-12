package com.kee.sptringbootmastergradle.controller;

import com.kee.sptringbootmastergradle.entity.User;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.ErrorBeanWechatPay;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.wechatpay.Unifiedorder;
import com.kee.sptringbootmastergradle.utils.net.resultpojo.ErrorTypeEnum;
import com.kee.sptringbootmastergradle.utils.net.resultpojo.ResultJsonBean;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/notify")
public class PayCallBackController {

    @RequestMapping("/test")
    public ResultJsonBean hello() {
        return ResultJsonBean.returnOK();
    }

    @RequestMapping("/wechatpay")
    public String wechatNotify(String info, HttpServletResponse response) throws Exception {
        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);
//        Unifiedorder read = serializer.read(Unifiedorder.class, info);
//        System.out.println(read);
        ErrorBeanWechatPay errorBeanWechatPay = new ErrorBeanWechatPay();
        errorBeanWechatPay.setReturn_code("SUCCESS");
        errorBeanWechatPay.setReturn_msg("OK");
//        ServletOutputStream outputStream = response.getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serializer.write(errorBeanWechatPay, byteArrayOutputStream);
        String string = byteArrayOutputStream.toString();
        System.out.println(string);
        return string;
    }
}
