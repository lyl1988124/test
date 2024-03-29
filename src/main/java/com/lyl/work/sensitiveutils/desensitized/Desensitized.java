package com.lyl.work.sensitiveutils.desensitized;

import java.lang.annotation.*;

/**
 
 * <p> Description : Desensitized
 *
 * @author : liuyuanlong
 * @date : 2022/6/23 13:05
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitized {
    /*脱敏类型(规则)*/
    SensitiveTypeEnum type();

    /*判断注解是否生效的方法*/
    String isEffictiveMethod() default "";
}
