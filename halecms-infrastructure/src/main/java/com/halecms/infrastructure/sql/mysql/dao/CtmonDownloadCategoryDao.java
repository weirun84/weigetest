package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonDownloadCategory;

public interface CtmonDownloadCategoryDao {
    int deleteByPrimaryKey(Integer catId);

    int insert(CtmonDownloadCategory record);

    int insertSelective(CtmonDownloadCategory record);

    CtmonDownloadCategory selectByPrimaryKey(Integer catId);

    int updateByPrimaryKeySelective(CtmonDownloadCategory record);

    int updateByPrimaryKey(CtmonDownloadCategory record);
}