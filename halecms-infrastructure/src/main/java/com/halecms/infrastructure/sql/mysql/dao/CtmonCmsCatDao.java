package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonCmsCat;

public interface CtmonCmsCatDao {
    int deleteByPrimaryKey(Integer catId);

    int insert(CtmonCmsCat record);

    int insertSelective(CtmonCmsCat record);

    CtmonCmsCat selectByPrimaryKey(Integer catId);

    int updateByPrimaryKeySelective(CtmonCmsCat record);

    int updateByPrimaryKey(CtmonCmsCat record);
}