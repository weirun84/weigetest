package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminuser;

import java.util.List;
import java.util.Map;

public interface CtmonAdminuserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(CtmonAdminuser record);

    int insertSelective(CtmonAdminuser record);

    CtmonAdminuser selectByPrimaryKey(Integer userId);

    CtmonAdminuser GetAdminUserInfo(String username);

    public List<CtmonAdminuser> findByPager(Map<String, Object> params);

    public long count();

    int updateByPrimaryKeySelective(CtmonAdminuser record);

    int updateByPrimaryKey(CtmonAdminuser record);
}