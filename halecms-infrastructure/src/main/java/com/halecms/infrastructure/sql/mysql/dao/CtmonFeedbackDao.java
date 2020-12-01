package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonFeedback;

public interface CtmonFeedbackDao {
    int deleteByPrimaryKey(Integer msgId);

    int insert(CtmonFeedback record);

    int insertSelective(CtmonFeedback record);

    CtmonFeedback selectByPrimaryKey(Integer msgId);

    int GetFeedBackCount();

    int updateByPrimaryKeySelective(CtmonFeedback record);

    int updateByPrimaryKey(CtmonFeedback record);
}