package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonConfig;

public interface CtmonConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CtmonConfig record);

    int insertSelective(CtmonConfig record);

    CtmonConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CtmonConfig record);

    int updateByPrimaryKey(CtmonConfig record);
}