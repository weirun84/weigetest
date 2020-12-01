package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonComment;

public interface CtmonCommentDao {
    int deleteByPrimaryKey(Integer commentId);

    int insert(CtmonComment record);

    int insertSelective(CtmonComment record);

    CtmonComment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CtmonComment record);

    int updateByPrimaryKey(CtmonComment record);
}