package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonGoodsdetails;

public interface CtmonGoodsdetailsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CtmonGoodsdetails record);

    int insertSelective(CtmonGoodsdetails record);

    CtmonGoodsdetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CtmonGoodsdetails record);

    int updateByPrimaryKey(CtmonGoodsdetails record);
}