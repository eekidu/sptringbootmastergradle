package com.kee.sptringbootmastergradle.moudle.wechat.api;


import com.kee.sptringbootmastergradle.exception.WechatApiException;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.oauth.WeChatAccessToken;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.oauth.WeChatUserInfo;
import io.reactivex.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 与微信服务器通信接口说明：<br>
 * { https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419317851&token=&lang=zh_CN }
 * https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419317853&lang=zh_CN
 * <p>
 * 步骤：<br>
 * 1.APP端发起授权，用户授权，获取code<br>
 * 2.通过code调用{@link WeChatOAuthAPI#accessToken} 获取AccessToken
 */
public interface WeChatOAuthAPI {

    String BASE_URL = "https://api.weixin.qq.com/sns/";

    /**
     * 通过code获取access_token
     * https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
     * <p>
     * error:   {"errcode":40002,"errmsg":"invalid grant_type, hints: [ req_id: 2yJ_50120th20 ]"}
     * success: {"access_token":"ACCESS_TOKEN", "expires_in":7200, "refresh_token":"REFRESH_TOKEN", "openid":"OPENID", "scope":"SCOPE", "unionid":"o6_bmasdasdsad6_2sgVt7hMZOPfL"}
     *
     * @param appid      应用唯一标识，在微信开放平台提交应用审核通过后获得
     * @param secret     应用密钥AppSecret，在微信开放平台提交应用审核通过后获得
     * @param code       填写第一步获取的code参数
     * @param grant_type 填authorization_code
     * @return
     */

    @GET("oauth2/access_token")
    Call<WeChatAccessToken> accessToken(@Query("appid") String appid, @Query("secret") String secret, @Query("code") String code,
                                        @Query("grant_type") String grant_type) throws WechatApiException;


    /**
     * 刷新access_token有效期
     * https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
     * {"errcode":40013,"errmsg":"invalid appid, hints: [ req_id: ZzHfMa0282th31 ]"}
     *
     * @param appid         应用唯一标识
     * @param grant_type    填refresh_token
     * @param refresh_token 填写通过access_token获取到的refresh_token参数
     * @return
     */
    @GET("oauth2/refresh_token")
    Call<String> refreshToken(@Query("appid") String appid, @Query("grant_type") String grant_type, @Query("refresh_token") String refresh_token);


    /**
     * 检验授权凭证（access_token）是否有效
     *
     * @param access_token
     * @param openid
     * @return
     */
    @GET("auth")
    Call<String> auth(@Query("access_token") String access_token, @Query("openid") String openid);


    /**
     * 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
     *
     * @param access_token
     * @param openid
     * @param lang
     * @return
     */
    @GET("userinfo")
    Call<WeChatUserInfo> userInfo(@Query("access_token") String access_token, @Query("openid") String openid, @Nullable @Query("lang") String lang);


}


