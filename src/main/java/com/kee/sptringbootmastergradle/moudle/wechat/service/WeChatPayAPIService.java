package com.kee.sptringbootmastergradle.moudle.wechat.service;

import com.kee.sptringbootmastergradle.moudle.wechat.WechatAliConfig;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.wechatpay.Unifiedorder;
import com.kee.sptringbootmastergradle.utils.net.APIManager;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Service
public class WeChatPayAPIService {


    public void unifiedorder(){
        Unifiedorder unifiedorder=new Unifiedorder();
        unifiedorder.setAppid(WechatAliConfig.getmWechatAppId());

        String uni="<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <attach>支付测试</attach>\n" +
                "   <body>APP支付测试</body>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>\n" +
                "   <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>\n" +
                "   <out_trade_no>1415659990</out_trade_no>\n" +
                "   <spbill_create_ip>14.23.150.211</spbill_create_ip>\n" +
                "   <total_fee>1</total_fee>\n" +
                "   <trade_type>APP</trade_type>\n" +
                "   <sign>0CB01533B8C1EF103065174F50BCA001</sign>\n" +
                "</xml> ";
        Call<String> call = APIManager.getInstance().getWeChatPayAPI().unifiedorder(uni);
        try {
            Response<String> execute = call.execute();
            String body = execute.body();
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
