package com.kee.sptringbootmastergradle.moudle.wechat.annotation;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ApiRequestField{

}
