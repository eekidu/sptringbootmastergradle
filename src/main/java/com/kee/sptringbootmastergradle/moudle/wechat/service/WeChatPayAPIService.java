package com.kee.sptringbootmastergradle.moudle.wechat.service;

import com.kee.sptringbootmastergradle.moudle.wechat.WechatAliConfig;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.wechatpay.Unifiedorder;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.wechatpay.UnifiedorderResult;
import com.kee.sptringbootmastergradle.utils.net.APIManager;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class WeChatPayAPIService {


    public void unifiedorder() {
        Unifiedorder unifiedorder = new Unifiedorder();

        unifiedorder.setAppid(WechatAliConfig.getmWechatAppId());
        unifiedorder.setAttach("支付测试");
        unifiedorder.setBody("APP支付测试");
        unifiedorder.setMch_id("10000100");
        unifiedorder.setNonce_str("1add1a30ac87aa2db72f57a2375d8fec");
        unifiedorder.setNotify_url("http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php");
        unifiedorder.setOut_trade_no("1415659990");
        unifiedorder.setSpbill_create_ip("14.23.150.211");
        unifiedorder.setTotal_fee("1");
        unifiedorder.setTrade_type("APP");
        unifiedorder.setSign("0CB01533B8C1EF103065174F50BCA001");

        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            serializer.write(unifiedorder, byteArrayOutputStream);
            Call<UnifiedorderResult> call = APIManager.getInstance().getWeChatPayAPI().unifiedorder(byteArrayOutputStream.toString());
            Response<UnifiedorderResult> execute = call.execute();
            UnifiedorderResult body = execute.body();

            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
