package com.kee.sptringbootmastergradle.moudle.wechat;

import java.util.ResourceBundle;

public class WechatAliConfig {
    private static String mWechatAppId;
    private static String mWechatSecret;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("wechataliconfig");
        mWechatAppId = resourceBundle.getString("WechatAppId");
        mWechatSecret = resourceBundle.getString("WechatSecret");
    }

    public static String getmWechatAppId() {
        return mWechatAppId;
    }

    public static String getmWechatSecret() {
        return mWechatSecret;
    }
}
