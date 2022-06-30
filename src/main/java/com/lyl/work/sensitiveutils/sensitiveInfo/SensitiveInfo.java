package com.lyl.work.sensitiveutils.sensitiveInfo;

import java.lang.annotation.*;

/**
 
 * <p> Description : SensitiveInfo
 *
 * @author : liuyuanlong
 * @date : 2022/6/23 15:05
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveInfo {

    public SensitiveInfoUtils.SensitiveType type();
}
