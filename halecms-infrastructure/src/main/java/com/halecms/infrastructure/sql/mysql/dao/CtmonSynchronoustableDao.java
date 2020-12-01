package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonSynchronoustable;

public interface CtmonSynchronoustableDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CtmonSynchronoustable record);

    int insertSelective(CtmonSynchronoustable record);

    CtmonSynchronoustable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CtmonSynchronoustable record);

    int updateByPrimaryKey(CtmonSynchronoustable record);
}