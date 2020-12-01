package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonCshtype;

public interface CtmonCshtypeDao {
    int deleteByPrimaryKey(Integer typeId);

    int insert(CtmonCshtype record);

    int insertSelective(CtmonCshtype record);

    CtmonCshtype selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(CtmonCshtype record);

    int updateByPrimaryKey(CtmonCshtype record);
}