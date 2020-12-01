package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonCmsLink;

public interface CtmonCmsLinkDao {
    int deleteByPrimaryKey(Integer linkId);

    int insert(CtmonCmsLink record);

    int insertSelective(CtmonCmsLink record);

    CtmonCmsLink selectByPrimaryKey(Integer linkId);

    int updateByPrimaryKeySelective(CtmonCmsLink record);

    int updateByPrimaryKey(CtmonCmsLink record);
}