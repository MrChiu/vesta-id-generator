package com.robert.vesta.service.impl.converter;

import com.robert.vesta.service.bean.Id;

/**
 * ID元数据与长整型转换
 */
public interface IdConverter {

    public long convert(Id id);

    public Id convert(long id);

}
