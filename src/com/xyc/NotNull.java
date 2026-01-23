package com.xyc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//使用这个注解 期望 检查 一个字段不为空
@Target(ElementType.FIELD)
public @interface NotNull {

}
