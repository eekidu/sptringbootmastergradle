package com.kee.sptringbootmastergradle.moudle.wechat.netpojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

//<xml><return_code><![CDATA[FAIL]]></return_code>
//<return_msg><![CDATA[appid不存在]]></return_msg>
//</xml>
@Root(name = "xml", strict = false)
public class ErrorBeanWechatPay {
    @Element
    protected String return_code;
    @Element(required = false)
    protected String return_msg;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    @Override
    public String toString() {
        return "ErrorBeanWechatPay{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                '}';
    }
}
