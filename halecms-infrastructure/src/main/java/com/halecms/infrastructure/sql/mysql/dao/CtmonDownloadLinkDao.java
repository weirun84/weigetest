package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonDownloadLink;

public interface CtmonDownloadLinkDao {
    int deleteByPrimaryKey(Integer linkId);

    int insert(CtmonDownloadLink record);

    int insertSelective(CtmonDownloadLink record);

    CtmonDownloadLink selectByPrimaryKey(Integer linkId);

    int updateByPrimaryKeySelective(CtmonDownloadLink record);

    int updateByPrimaryKey(CtmonDownloadLink record);
}