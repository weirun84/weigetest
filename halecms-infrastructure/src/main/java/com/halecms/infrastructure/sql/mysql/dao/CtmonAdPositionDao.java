package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdPosition;

public interface CtmonAdPositionDao {
    int deleteByPrimaryKey(Integer positionId);

    int insert(CtmonAdPosition record);

    int insertSelective(CtmonAdPosition record);

    CtmonAdPosition selectByPrimaryKey(Integer positionId);

    int updateByPrimaryKeySelective(CtmonAdPosition record);

    int updateByPrimaryKey(CtmonAdPosition record);
}