package com.kee.sptringbootmastergradle.moudle.wechat.service;


import com.kee.sptringbootmastergradle.exception.WechatApiException;

import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.oauth.WeChatAccessToken;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.oauth.WeChatUserInfo;
import com.kee.sptringbootmastergradle.moudle.wechat.WechatAliConfig;
import com.kee.sptringbootmastergradle.utils.net.APIManager;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;


import java.io.IOException;

@Service
public class WeChatOAuthAPIService {

    /**
     * 获取AccessToken
     *
     * @param code
     * @return
     * @throws WechatApiException
     */
    public WeChatAccessToken accessToken(String code) throws WechatApiException {
        Call<WeChatAccessToken> stringCall = APIManager.getInstance().getWeChatOAuthAPI().accessToken(WechatAliConfig.getmWechatAppId(),
                WechatAliConfig.getmWechatSecret(),
                code,
                "authorization_code"//固定值
        );
        Response<WeChatAccessToken> response = null;
        try {
            response = stringCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body();
    }

    /**
     * 刷新
     * @return
     */
    public String refreshToken() {
        Call<String> call = APIManager.getInstance().getWeChatOAuthAPI().refreshToken(WechatAliConfig.getmWechatAppId(), "refresh_token", "reftoken");
        Response<String> execute = null;
        try {
            execute = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(execute.body());
        return execute.body();
    }


    /**
     * 获取用户信息
     *
     * @param access_token
     * @param openid
     * @return
     * @throws WechatApiException
     */
    public WeChatUserInfo userInfo(String access_token, String openid) throws WechatApiException {
        Call<WeChatUserInfo> call = APIManager.getInstance().getWeChatOAuthAPI().userInfo(
                access_token,
                openid,
                "zh_CN");
        Response<WeChatUserInfo> execute = null;
        try {
            execute = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return execute.body();
    }
}
