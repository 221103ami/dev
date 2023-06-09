package com.kh.app.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface KhService {
	
	String value() default "defauleValuezzzzz";

}
