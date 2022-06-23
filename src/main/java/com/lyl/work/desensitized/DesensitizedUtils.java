package com.lyl.work.desensitized;


import com.zettacloud.idps.common.lang.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
 * <p> Description : DesensitizedUtils
 *
 * @author : liuyuanlong
 * @date : 2022/6/23 13:02
 */
public class DesensitizedUtils {
    private static final Logger logger = LoggerFactory.getLogger(DesensitizedUtils.class);

    /**
     * 脱敏处理方法
     *
     * @param object
     * @return
     */
    public static String getConverent(Object object) {

        String objClassName = object.getClass().getName();

        try {
            // 2.处理Object数据类型
            Object val;
            Class<?> objClazz = Class.forName(objClassName);
            Field[] declaredFields = objClazz.getDeclaredFields();
            for (int j = 0; j < declaredFields.length; j++) {

                declaredFields[j].setAccessible(true);
                Desensitized annotation = declaredFields[j].getAnnotation(Desensitized.class);
                if (null == annotation) {
                    continue;
                }

                val = declaredFields[j].get(object);

                // 只处理String类型数据
                if (!(val instanceof String)) {
                    continue;
                }
                String value = doconverentForObject(val, annotation.type().name());
                declaredFields[j].set(object, value);
            }
            return JsonUtils.objectToJson(object);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("日志脱敏处理失败，回滚，详细信息:[{}]", new Object[]{e});
            return JsonUtils.objectToJson(object);
        }
    }

    /**
     * 脱敏数据源为Object时处理方式
     *
     * @param val
     * @param annotationName
     * @return
     */
    private static String doconverentForObject(Object val, String annotationName) {

        String value = String.valueOf(val);
        if (StringUtils.isNotEmpty(value)) {
            value = doConverentByType(value, annotationName);
        }
        return value;
    }

    /**
     * 根据不同注解类型处理不同字段
     *
     * @param value
     * @param annotationName
     * @return
     */
    private static String doConverentByType(String value, String annotationName) {

        SensitiveTypeEnum typeEnum = SensitiveTypeEnum.valueOf(annotationName);

        switch (typeEnum) {
            case PASSWORD:
                value = getStringByLength(value);
                break;
            default:
                value = getStringByLength(value);
        }
        return value;
    }

    /**
     * 根据value长度取值(切分)
     *
     * @param value
     * @return
     */
    private static String getStringByLength(String value) {
        int length = value.length();
        if (length == 2) {
            value = value.substring(0, 1) + "*";
        } else if (length == 3) {
            value = value.substring(0, 1) + "*" + value.substring(length - 1);
        } else if (length > 3 && length <= 5) {
            value = value.substring(0, 1) + "**" + value.substring(length - 2);
        } else if (length > 5 && length <= 7) {
            value = value.substring(0, 2) + "***" + value.substring(length - 2);
        } else if (length > 7) {
            value = value.substring(0, 3) + "*****" + value.substring(length - 3);
        }
        return value;
    }
}
