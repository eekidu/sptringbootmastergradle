package com.kee.sptringbootmastergradle.moudle.wechat.netpojo.wechatpay;

import com.kee.sptringbootmastergradle.moudle.wechat.annotation.ApiRequestField;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.ErrorBeanWechatPay;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_1
 * <xml>
 * <return_code><![CDATA[SUCCESS]]></return_code>
 * <return_msg><![CDATA[OK]]></return_msg>
 * <appid><![CDATA[wx2421b1c4370ec43b]]></appid>
 * <mch_id><![CDATA[10000100]]></mch_id>
 * <nonce_str><![CDATA[IITRi8Iabbblz1Jc]]></nonce_str>
 * <sign><![CDATA[7921E432F65EB8ED0CE9755F0E86D72F]]></sign>
 * <result_code><![CDATA[SUCCESS]]></result_code>
 * <prepay_id><![CDATA[wx201411101639507cbf6ffd8b0779950874]]></prepay_id>
 * <trade_type><![CDATA[APP]]></trade_type>
 * </xml>
 */
@Root(strict = false)
@Element
public class UnifiedorderResult extends ErrorBeanWechatPay{
    /**
     * 调用接口提交的应用ID
     */
    @Element(required = false)
    private String appid;

    /**
     * 调用接口提交的商户号
     */
    @Element(required = false)
    private String mch_id;

    /**
     * 微信返回的随机字符串
     */
    @Element(required = false)
    private String nonce_str;

    /**
     * 微信返回的签名，详见签名算法
     */
    @Element(required = false)
    private String sign;

    /**
     * 业务结果SUCCESS/FAIL
     */
    @Element(required = false)
    private String result_code;

    /***********************  非必返回 *******************************/

    /**
     * 设备号:调用接口提交的终端设备号
     */
    @Element(required = false)
    private String device_info;

    /**
     * 详细参见第6节错误列表
     * 错误代码
     */
    @Element(required = false)
    private String err_code;

    /**
     * 错误返回的信息描述
     */
    @Element(required = false)
    private String err_code_des;

    /**********************  以下字段在return_code 和result_code都为SUCCESS的时候有返回   *********************************/

    /**
     * JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付，统一下单接口trade_type的传参可参考这里
     */
    @Element(required = false)
    private String trade_type;
    /**
     * 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    @Element(required = false)
    private String prepay_id;


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }


    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    @Override
    public String toString() {
        return "UnifiedorderResult{" +
                "appid='" + appid + '\'' +
                ", mch_id='" + mch_id + '\'' +
                ", nonce_str='" + nonce_str + '\'' +
                ", sign='" + sign + '\'' +
                ", result_code='" + result_code + '\'' +
                ", device_info='" + device_info + '\'' +
                ", err_code='" + err_code + '\'' +
                ", err_code_des='" + err_code_des + '\'' +
                ", trade_type='" + trade_type + '\'' +
                ", prepay_id='" + prepay_id + '\'' +
                ", return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                '}';
    }
}
