package com.kee.sptringbootmastergradle.exception;

public class WechatApiException extends RuntimeException {
    private int errcode;
    private String errmsg;

    public WechatApiException(int errcode, String errmsg) {
        super("errcode:" + errcode + " ,message:" + errmsg);
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }
}
