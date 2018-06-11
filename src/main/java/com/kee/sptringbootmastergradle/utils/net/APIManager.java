package com.kee.sptringbootmastergradle.utils.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kee.sptringbootmastergradle.moudle.wechat.api.WeChatOAuthAPI;
import com.kee.sptringbootmastergradle.moudle.wechat.api.WeChatPayAPI;
import com.kee.sptringbootmastergradle.utils.net.converter.MyGsonConverterFactory;
import com.kee.sptringbootmastergradle.utils.net.intercept.WechatExceptionIntercept;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class APIManager {
    private volatile static APIManager instance;

    private APIManager() {
        init();
    }

    public static APIManager getInstance() {
        if (instance == null)
            synchronized (APIManager.class) {
                if (instance == null) {
                    instance = new APIManager();
                }
            }
        return instance;
    }


    OkHttpClient commonClient;
    Retrofit wechatOAuthRetrofit;
    WeChatOAuthAPI weChatOAuthAPI;


    Retrofit wechatPayRetrofit;
    WeChatPayAPI weChatPayAPI;


    private static Gson mGson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:MM:ss").serializeNulls().create();

    private void init() {
        commonClient = new OkHttpClient.Builder()
                .addInterceptor(new WechatExceptionIntercept())
                .build();
        wechatOAuthRetrofit = new Retrofit.Builder()
                .baseUrl(WeChatOAuthAPI.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(MyGsonConverterFactory.create(mGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(commonClient)
                .build();
        weChatOAuthAPI = wechatOAuthRetrofit.create(WeChatOAuthAPI.class);

        wechatPayRetrofit = new Retrofit.Builder()
                .baseUrl(WeChatPayAPI.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(commonClient)
                .build();
        weChatPayAPI = wechatPayRetrofit.create(WeChatPayAPI.class);

    }

    public WeChatOAuthAPI getWeChatOAuthAPI() {
        return weChatOAuthAPI;
    }

    public WeChatPayAPI getWeChatPayAPI() {
        return weChatPayAPI;
    }
}
