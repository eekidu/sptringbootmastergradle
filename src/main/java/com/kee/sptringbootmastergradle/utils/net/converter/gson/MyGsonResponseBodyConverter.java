package com.kee.sptringbootmastergradle.utils.net.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import com.kee.sptringbootmastergradle.exception.WechatApiException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import retrofit2.Converter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public final class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }


    /**
     * 解析时如果返回错误，抛出异常进行处理
     *
     * @param responseBody
     * @return
     * @throws IOException
     */
    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        String responseBodyString = responseBody.string();
        JsonObject asJsonObject = new JsonParser().parse(responseBodyString).getAsJsonObject();
        if (asJsonObject.has("errcode")) {
            int errcode = asJsonObject.get("errcode").getAsInt();
            String errmsg = asJsonObject.get("errmsg").getAsString();
            if (errcode > 0)
                throw new WechatApiException(errcode, errmsg);
        }
//        JsonReader jsonReader = gson.newJsonReader(responseBody.charStream());
        MediaType mediaType = responseBody.contentType();
        Charset charset = mediaType != null ? mediaType.charset(Util.UTF_8) : Util.UTF_8;
        InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(responseBodyString.getBytes()), charset);
        JsonReader jsonReader = gson.newJsonReader(inputStreamReader);
        try {
            return adapter.read(jsonReader);
        } finally {
            responseBody.close();
        }
    }
}
