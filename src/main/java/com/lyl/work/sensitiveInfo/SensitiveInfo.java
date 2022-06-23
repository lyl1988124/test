package com.lyl.work.sensitiveInfo;

import java.lang.annotation.*;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
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
