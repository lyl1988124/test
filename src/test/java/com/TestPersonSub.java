package com;

import com.lyl.work.desensitized.Desensitized;
import com.lyl.work.desensitized.SensitiveTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
 * <p> Description : TestPersonSub
 *
 * @author : liuyuanlong
 * @date : 2022/6/23 14:55
 */
public class TestPersonSub {

    @Desensitized(type = SensitiveTypeEnum.PASSWORD)
    private String subName;


    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
