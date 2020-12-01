package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonGoodsCategory;

public interface CtmonGoodsCategoryDao {
    int deleteByPrimaryKey(Integer catId);

    int insert(CtmonGoodsCategory record);

    int insertSelective(CtmonGoodsCategory record);

    CtmonGoodsCategory selectByPrimaryKey(Integer catId);

    int updateByPrimaryKeySelective(CtmonGoodsCategory record);

    int updateByPrimaryKey(CtmonGoodsCategory record);
}