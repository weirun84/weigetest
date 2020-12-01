package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonSearch;

public interface CtmonSearchDao {
    int deleteByPrimaryKey(Integer searchId);

    int insert(CtmonSearch record);

    int insertSelective(CtmonSearch record);

    CtmonSearch selectByPrimaryKey(Integer searchId);

    int updateByPrimaryKeySelective(CtmonSearch record);

    int updateByPrimaryKey(CtmonSearch record);
}