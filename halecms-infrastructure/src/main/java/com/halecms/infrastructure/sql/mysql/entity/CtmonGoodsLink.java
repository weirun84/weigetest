package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_goods_link
 * @author 
 */
@Data
public class CtmonGoodsLink implements Serializable {
    private Integer linkId;

    private Integer goodsId;

    private Integer linkGoodsId;

    private Boolean isDouble;

    private Integer adminId;

    private Integer type;

    private Integer linkCmsId;

    private Integer linkDowsloadId;

    private static final long serialVersionUID = 1L;
}