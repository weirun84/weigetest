package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonCms;

public interface CtmonCmsDao {
    int deleteByPrimaryKey(Integer articleId);

    int insert(CtmonCms record);

    int insertSelective(CtmonCms record);

    CtmonCms selectByPrimaryKey(Integer articleId);

    int GetCmsCount();

    int updateByPrimaryKeySelective(CtmonCms record);

    int updateByPrimaryKey(CtmonCms record);
}