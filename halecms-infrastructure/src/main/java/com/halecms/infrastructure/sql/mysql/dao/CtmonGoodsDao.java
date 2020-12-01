package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonGoods;

public interface CtmonGoodsDao {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(CtmonGoods record);

    int insertSelective(CtmonGoods record);

    CtmonGoods selectByPrimaryKey(Integer goodsId);

    int GetGoodsCount();

    int updateByPrimaryKeySelective(CtmonGoods record);

    int updateByPrimaryKey(CtmonGoods record);
}