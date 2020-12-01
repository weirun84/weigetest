package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminuser;
import com.halecms.infrastructure.sql.mysql.entity.CtmonJobposition;

import java.util.List;
import java.util.Map;

public interface CtmonJobpositionDao {
    int deleteByPrimaryKey(Integer positionId);

    int insert(CtmonJobposition record);

    int insertSelective(CtmonJobposition record);

    CtmonJobposition selectByPrimaryKey(Integer positionId);

    int updateByPrimaryKeySelective(CtmonJobposition record);

    int updateByPrimaryKey(CtmonJobposition record);

    public long count();

    public List<CtmonJobposition> findByPager(Map<String, Object> params);
}