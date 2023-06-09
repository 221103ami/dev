package com.kh.app.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface KhPostMapping {
	
	String value() default "defauleValuezzzzz";
//	String getReqPath();	//근데 value 가 어차피 기본으로 잡히니까 굳이 이런 이름으로 쓸 필요 X

}
