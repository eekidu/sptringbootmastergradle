package com.kee.sptringbootmastergradle.utils.net.resultpojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultJsonBean<T> {

    private int errCode;
    private String errMsg;
    private T data;
    private Map<String, Object> extra;//附加数据，字段、内容不定


    public static ResultJsonBean returnOK() {
        return new ResultJsonBean().setSystemError(ErrorTypeEnum.OK);
    }

    public static <T> ResultJsonBean returnOK(T data) {
        return new ResultJsonBean().setSystemError(ErrorTypeEnum.OK).setData(data);
    }

    public static ResultJsonBean returnError(ErrorTypeEnum errorTypeEnum) {
        return new ResultJsonBean().setSystemError(errorTypeEnum);
    }

    public static ResultJsonBean returnError(ErrorTypeEnum errorTypeEnum, String errMsg) {
        return new ResultJsonBean().setSystemError(errorTypeEnum).appendErrMsg(errMsg);
    }


//    public boolean isSuccess() {
//        return errCode == ErrorTypeEnum.OK.getErrcode();
//    }

    /**
     * 设置错误详细信息
     * 错误类型的来源可以是枚举、静态类或者数据库，在该方法进行实现
     *
     * @return
     */
    public ResultJsonBean setSystemError(ErrorTypeEnum errBean) {
        this.setErrCode(errBean.getErrcode());
        this.setErrMsg(errBean.getErrmessage());
        return this;
    }

    public ResultJsonBean setSystemError(ErrorTypeEnum errBean, String errMsg) {
        this.setErrCode(errBean.getErrcode());
        this.setErrMsg(errBean.getErrmessage() + ":" + errMsg);
        return this;
    }

    public ResultJsonBean appendErrMsg(String errMsg) {
        this.errMsg += "," + errMsg;
        return this;
    }

    /**
     * 添加条目到返回数据体中，返回数据体必须为数组形式
     *
     * @param e
     * @param <E>
     * @return
     */
    public <E> ResultJsonBean addBodyArrayItem(E e) {
        if (data == null) {
            this.data = (T) new ArrayList<E>();
        }
        if (data instanceof List) {
            List<E> data = (List<E>) this.data;
            data.add(e);
        } else {
            throw new RuntimeException("T is not instanceof List");
        }
        return this;
    }

    public <E> ResultJsonBean addBodyArrayAll(List<E> beanList) {
        if (data == null) {
            this.data = (T) new ArrayList<E>();
        }
        if (data instanceof List) {
            List<E> data = (List<E>) this.data;
            data.addAll(beanList);
        } else {
            throw new RuntimeException("T is not instanceof List");
        }
        return this;
    }

    public ResultJsonBean addExtraInfo(String key, Object value) {
        if (extra == null) {
            extra = new HashMap<String, Object>();
        }
        extra.put(key, value);
        return this;
    }

    /******************************************************************/

    public ResultJsonBean<T> setErrCode(int errCode) {
        this.errCode = errCode;
        return this;
    }

    public ResultJsonBean<T> setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public ResultJsonBean<T> setData(T data) {
        this.data = data;
        return this;
    }

    public ResultJsonBean<T> setExtra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public T getData() {
        return data;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    @Override
    public String toString() {
        return "ResultJsonBean{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                ", data=" + data +
                ", extra=" + extra +
                '}';
    }
}
