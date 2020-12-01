package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminAction;

import java.util.List;

public interface CtmonAdminActionDao {
    int deleteByPrimaryKey(Integer actionId);

    int insert(CtmonAdminAction record);

    int insertSelective(CtmonAdminAction record);

    CtmonAdminAction selectByPrimaryKey(Integer actionId);

    List<CtmonAdminAction> GetAllaction();

    int updateByPrimaryKeySelective(CtmonAdminAction record);

    int updateByPrimaryKey(CtmonAdminAction record);
}