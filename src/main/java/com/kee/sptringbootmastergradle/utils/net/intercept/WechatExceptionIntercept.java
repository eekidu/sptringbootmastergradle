package com.kee.sptringbootmastergradle.utils.net.intercept;

import com.kee.sptringbootmastergradle.exception.WechatApiException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WechatExceptionIntercept implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        if (!proceed.isSuccessful()) {
            throw new WechatApiException(proceed.code(), proceed.message());
        }
        return proceed;
    }
}
