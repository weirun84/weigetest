package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonLbs;

public interface CtmonLbsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CtmonLbs record);

    int insertSelective(CtmonLbs record);

    CtmonLbs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CtmonLbs record);

    int updateByPrimaryKey(CtmonLbs record);
}