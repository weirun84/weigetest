package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_goodsdetails
 * @author 
 */
@Data
public class CtmonGoodsdetails implements Serializable {
    private Integer id;

    private Integer goodsId;

    private String detailsName;

    private String details;

    private Boolean isMoren;

    private static final long serialVersionUID = 1L;
}