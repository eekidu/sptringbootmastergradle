package com.kee.sptringbootmastergradle.exception;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理类，可以判断是网页请求、ajax请求、api请求，返回不同形式的错误展示形式
 */
//@ControllerAdvice
public class AppExceptionHandler {
    public static final String APP_ERROR_VIEW = "error";

    //    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) throws Exception {
        ex.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(APP_ERROR_VIEW);
        return mav;
    }

    /**
     * 判断是否是ajax请求
     *
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        return header != null && "XMLHttpRequest".equals(header);
    }
}
