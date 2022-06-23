package com;

import com.lyl.work.desensitized.Desensitized;
import com.lyl.work.desensitized.SensitiveTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
 * <p> Description : TestPerson
 *
 * @author : liuyuanlong
 * @date : 2022/6/23 13:22
 */
public class TestPerson {

    @Desensitized(type = SensitiveTypeEnum.PASSWORD)
    private String custName;

    @Desensitized(type = SensitiveTypeEnum.PASSWORD)
    private int idNo;

    private String certNo;

    private TestPersonSub personSub;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public TestPersonSub getPersonSub() {
        return personSub;
    }

    public void setPersonSub(TestPersonSub personSub) {
        this.personSub = personSub;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
