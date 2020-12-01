package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonNavigate;

public interface CtmonNavigateDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CtmonNavigate record);

    int insertSelective(CtmonNavigate record);

    CtmonNavigate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CtmonNavigate record);

    int updateByPrimaryKey(CtmonNavigate record);
}