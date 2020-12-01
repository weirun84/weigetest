package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_goods_attr
 * @author 
 */
@Data
public class CtmonGoodsAttr implements Serializable {
    private Integer goodsAttrId;

    private Integer goodsId;

    private Integer attrId;

    private String attrValue;

    private Integer attrType;

    private Integer articleId;

    private static final long serialVersionUID = 1L;
}