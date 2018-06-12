package com.kee.sptringbootmastergradle.moudle.wechat.netpojo.wechatpay;

import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.ErrorBeanWechatPay;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class UnifieddorderNotify {
    @Element(required = false)
    private String appid;
    @Element(required = false)
    private String attach;
    @Element(required = false)
    private String bank_type;
    @Element(required = false)
    private String fee_type;
    @Element(required = false)
    private String is_subscribe;
    @Element(required = false)
    private String mch_id;
    @Element(required = false)
    private String nonce_str;
    @Element(required = false)
    private String openid;
    @Element(required = false)
    private String out_trade_no;
    @Element(required = false)
    private String result_code;
    @Element(required = false)
    private String return_code;
    @Element(required = false)
    private String sign;
    @Element(required = false)
    private String sub_mch_id;
    @Element(required = false)
    private String time_end;
    @Element(required = false)
    private String total_fee;
    @Element(required = false)
    private String coupon_count;
    @Element(required = false)
    private String coupon_type;
    @Element(required = false)
    private String coupon_id;
    @Element(required = false)
    private String coupon_fee;
    @Element(required = false)
    private String trade_type;
    @Element(required = false)
    private String transaction_id;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getCoupon_count() {
        return coupon_count;
    }

    public void setCoupon_count(String coupon_count) {
        this.coupon_count = coupon_count;
    }

    public String getCoupon_type() {
        return coupon_type;
    }

    public void setCoupon_type(String coupon_type) {
        this.coupon_type = coupon_type;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCoupon_fee() {
        return coupon_fee;
    }

    public void setCoupon_fee(String coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    @Override
    public String toString() {
        return "UnifieddorderNotify{" +
                "appid='" + appid + '\'' +
                ", attach='" + attach + '\'' +
                ", bank_type='" + bank_type + '\'' +
                ", fee_type='" + fee_type + '\'' +
                ", is_subscribe='" + is_subscribe + '\'' +
                ", mch_id='" + mch_id + '\'' +
                ", nonce_str='" + nonce_str + '\'' +
                ", openid='" + openid + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", result_code='" + result_code + '\'' +
                ", return_code='" + return_code + '\'' +
                ", sign='" + sign + '\'' +
                ", sub_mch_id='" + sub_mch_id + '\'' +
                ", time_end='" + time_end + '\'' +
                ", total_fee='" + total_fee + '\'' +
                ", coupon_count='" + coupon_count + '\'' +
                ", coupon_type='" + coupon_type + '\'' +
                ", coupon_id='" + coupon_id + '\'' +
                ", coupon_fee='" + coupon_fee + '\'' +
                ", trade_type='" + trade_type + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }
}
