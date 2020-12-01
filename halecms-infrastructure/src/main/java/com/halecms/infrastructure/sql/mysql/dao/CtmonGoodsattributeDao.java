package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonGoodsattribute;

public interface CtmonGoodsattributeDao {
    int deleteByPrimaryKey(Integer attrId);

    int insert(CtmonGoodsattribute record);

    int insertSelective(CtmonGoodsattribute record);

    CtmonGoodsattribute selectByPrimaryKey(Integer attrId);

    int updateByPrimaryKeySelective(CtmonGoodsattribute record);

    int updateByPrimaryKey(CtmonGoodsattribute record);
}