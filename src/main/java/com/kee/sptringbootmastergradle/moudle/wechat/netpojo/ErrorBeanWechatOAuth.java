package com.kee.sptringbootmastergradle.moudle.wechat.netpojo;

public class ErrorBeanWechatOAuth {
    /**
     * errcode : 40013
     * errmsg : invalid appid, hints: [ req_id: sNmCPa0454th41 ]
     */

    private int errcode;
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "ErrorBeanWechatOAuth{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
