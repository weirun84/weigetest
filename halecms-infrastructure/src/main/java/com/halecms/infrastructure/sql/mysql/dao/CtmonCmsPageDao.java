package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonCmsPage;

public interface CtmonCmsPageDao {
    int deleteByPrimaryKey(Integer pageId);

    int insert(CtmonCmsPage record);

    int insertSelective(CtmonCmsPage record);

    CtmonCmsPage selectByPrimaryKey(Integer pageId);

    int updateByPrimaryKeySelective(CtmonCmsPage record);

    int updateByPrimaryKey(CtmonCmsPage record);
}