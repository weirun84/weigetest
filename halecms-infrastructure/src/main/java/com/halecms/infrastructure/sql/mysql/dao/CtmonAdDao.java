package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAd;

public interface CtmonAdDao {
    int deleteByPrimaryKey(Integer adId);

    int insert(CtmonAd record);

    int insertSelective(CtmonAd record);

    CtmonAd selectByPrimaryKey(Integer adId);

    int updateByPrimaryKeySelective(CtmonAd record);

    int updateByPrimaryKey(CtmonAd record);
}