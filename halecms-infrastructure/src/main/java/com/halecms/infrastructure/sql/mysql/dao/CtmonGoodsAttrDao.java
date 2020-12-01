package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonGoodsAttr;

public interface CtmonGoodsAttrDao {
    int deleteByPrimaryKey(Integer goodsAttrId);

    int insert(CtmonGoodsAttr record);

    int insertSelective(CtmonGoodsAttr record);

    CtmonGoodsAttr selectByPrimaryKey(Integer goodsAttrId);

    int updateByPrimaryKeySelective(CtmonGoodsAttr record);

    int updateByPrimaryKey(CtmonGoodsAttr record);
}