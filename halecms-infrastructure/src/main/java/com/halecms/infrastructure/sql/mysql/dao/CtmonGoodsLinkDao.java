package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonGoodsLink;

public interface CtmonGoodsLinkDao {
    int deleteByPrimaryKey(Integer linkId);

    int insert(CtmonGoodsLink record);

    int insertSelective(CtmonGoodsLink record);

    CtmonGoodsLink selectByPrimaryKey(Integer linkId);

    int updateByPrimaryKeySelective(CtmonGoodsLink record);

    int updateByPrimaryKey(CtmonGoodsLink record);
}