package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonJobdepartment;

import java.util.List;

public interface CtmonJobdepartmentDao {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(CtmonJobdepartment record);

    int insertSelective(CtmonJobdepartment record);

    CtmonJobdepartment selectByPrimaryKey(Integer departmentId);

    List<CtmonJobdepartment> GetJobdepartment(String condition);

    int updateByPrimaryKeySelective(CtmonJobdepartment record);//GetJobdepartment

    int updateByPrimaryKey(CtmonJobdepartment record);
}