package com.kee.sptringbootmastergradle.entity;

public enum ErrorTypeEnum {
    OK(0, "Success"),
    /*----------------用户异常--------------------------*/
    USER_TOKEN_ERR(101, "用户TOKEN过期"),
    PARAMES_ERR(101, "参数异常"),
    /*----------------服务器异常--------------------------*/
    SERVICE_ERR(500, "服务器异常");

    ErrorTypeEnum(int errcode, String errmessage) {
        this.errcode = errcode;
        this.errmessage = errmessage;
    }

    private int errcode;
    private String errmessage;


    public int getErrcode() {
        return errcode;
    }

    public String getErrmessage() {
        return errmessage;
    }
}
