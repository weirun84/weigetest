package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminlog;

public interface CtmonAdminlogDao {
    int deleteByPrimaryKey(Integer logId);

    int insert(CtmonAdminlog record);

    int insertSelective(CtmonAdminlog record);

    CtmonAdminlog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(CtmonAdminlog record);

    int updateByPrimaryKey(CtmonAdminlog record);
}