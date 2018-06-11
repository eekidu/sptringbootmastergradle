package com.kee.sptringbootmastergradle.moudle.wechat.netpojo.wechatpay;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_1
 */
public class UnifiedorderResult {
    /**
     * 调用接口提交的应用ID
     */
    private String appid;

    /**
     * 调用接口提交的商户号
     */
    private String mch_id;

    /**
     * 微信返回的随机字符串
     */
    private String nonce_str;

    /**
     * 微信返回的签名，详见签名算法
     */
    private String sign;

    /**
     * 业务结果SUCCESS/FAIL
     */
    private String result_code;

    /***********************  非必返回 *******************************/

    /**
     * 设备号:调用接口提交的终端设备号
     */
    private String device_info;

    /**
     * 详细参见第6节错误列表
     * 错误代码
     */
    private String err_code;

    /**
     * 错误返回的信息描述
     */
    private String err_code_des;


}
