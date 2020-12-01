package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonCsh;

public interface CtmonCshDao {
    int deleteByPrimaryKey(Integer cshId);

    int insert(CtmonCsh record);

    int insertSelective(CtmonCsh record);

    CtmonCsh selectByPrimaryKey(Integer cshId);

    int updateByPrimaryKeySelective(CtmonCsh record);

    int updateByPrimaryKey(CtmonCsh record);
}