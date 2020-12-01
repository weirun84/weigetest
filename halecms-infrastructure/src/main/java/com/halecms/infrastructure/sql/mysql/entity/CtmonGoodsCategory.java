package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_goods_category
 * @author 
 */
@Data
public class CtmonGoodsCategory implements Serializable {
    private Integer catId;

    private Integer parentId;

    private String catName;

    private String catIco;

    private String catDesc;

    private String catPath;

    private String listTlp;

    private String infoTlp;

    private Integer catLevel;

    private Integer catSubcount;

    private String measureUnit;

    private Boolean showInNav;

    private Boolean isShow;

    private Boolean isHot;

    private Integer sortOrder;

    private Integer pageSize;

    private String urlrewriter;

    private String pagetitle;

    private String pagekeywords;

    private String pagedesc;

    private String pricearea;

    private String catNameEn;

    private Boolean isMobile;

    private String catHIco;

    private static final long serialVersionUID = 1L;
}