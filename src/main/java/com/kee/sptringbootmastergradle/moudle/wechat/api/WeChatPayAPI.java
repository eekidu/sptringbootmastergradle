package com.kee.sptringbootmastergradle.moudle.wechat.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WeChatPayAPI {
    String BASE_URL = "https://api.mch.weixin.qq.com/pay/";


    /**
     * @param orderInfo
     * @return
     */
    @POST("unifiedorder")
    Call<String> unifiedorder(@Body String orderInfo);
}
