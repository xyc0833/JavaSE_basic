package com.xyc01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//希望能检查一个字段的int类型
//这个注解只能贴在“成员变量”上 不能贴在类 / 方法 / 参数上
@Target(ElementType.FIELD)
//这个注解在“运行时还存在”  也就是说：JVM 运行时 可以用 反射 读到这个注解
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {
	int min() default 1;
	int max() default 100;
}
