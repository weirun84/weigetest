package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_goodsattribute
 * @author 
 */
@Data
public class CtmonGoodsattribute implements Serializable {
    private Integer attrId;

    private Integer typeId;

    private String attrName;

    private Integer attrInputType;

    private String attrValues;

    private Integer sortOrder;

    private Integer attrType;

    private static final long serialVersionUID = 1L;
}