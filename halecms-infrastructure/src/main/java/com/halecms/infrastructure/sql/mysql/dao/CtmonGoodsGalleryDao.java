package com.halecms.infrastructure.sql.mysql.dao;

import com.halecms.infrastructure.sql.mysql.entity.CtmonGoodsGallery;

public interface CtmonGoodsGalleryDao {
    int deleteByPrimaryKey(Integer imgId);

    int insert(CtmonGoodsGallery record);

    int insertSelective(CtmonGoodsGallery record);

    CtmonGoodsGallery selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(CtmonGoodsGallery record);

    int updateByPrimaryKey(CtmonGoodsGallery record);
}