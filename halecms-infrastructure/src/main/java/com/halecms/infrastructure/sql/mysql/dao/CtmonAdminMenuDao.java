package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminMenu;

import java.util.List;

public interface CtmonAdminMenuDao {
    int deleteByPrimaryKey(Integer menuId);

    int insert(CtmonAdminMenu record);

    int insertSelective(CtmonAdminMenu record);

    CtmonAdminMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(CtmonAdminMenu record);

    int updateByPrimaryKey(CtmonAdminMenu record);

    List<CtmonAdminMenu> GetAdminMenuAll();

    List<CtmonAdminMenu> GetChilendAdminMenu(Integer parentId);
}