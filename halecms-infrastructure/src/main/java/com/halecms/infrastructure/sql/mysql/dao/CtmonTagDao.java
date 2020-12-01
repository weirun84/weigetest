package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonTag;

public interface CtmonTagDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CtmonTag record);

    int insertSelective(CtmonTag record);

    CtmonTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CtmonTag record);

    int updateByPrimaryKey(CtmonTag record);
}