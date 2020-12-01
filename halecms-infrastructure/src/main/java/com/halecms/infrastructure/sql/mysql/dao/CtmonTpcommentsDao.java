package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonTpcomments;

public interface CtmonTpcommentsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CtmonTpcomments record);

    int insertSelective(CtmonTpcomments record);

    CtmonTpcomments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CtmonTpcomments record);

    int updateByPrimaryKey(CtmonTpcomments record);
}