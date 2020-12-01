package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonDownload;

public interface CtmonDownloadDao {
    int deleteByPrimaryKey(Integer downId);

    int insert(CtmonDownload record);

    int insertSelective(CtmonDownload record);

    CtmonDownload selectByPrimaryKey(Integer downId);

    int updateByPrimaryKeySelective(CtmonDownload record);

    int updateByPrimaryKey(CtmonDownload record);
}