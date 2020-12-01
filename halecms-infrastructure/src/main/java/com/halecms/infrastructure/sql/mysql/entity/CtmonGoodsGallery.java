package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_goods_gallery
 * @author 
 */
@Data
public class CtmonGoodsGallery implements Serializable {
    private Integer imgId;

    private Integer goodsId;

    private String imgDesc;

    private String goodsThumb;

    private String goodsImg;

    private String infoImg;

    private String originalImg;

    private Integer adminUserId;

    private Integer orderId;

    private static final long serialVersionUID = 1L;
}