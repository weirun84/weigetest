package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_goods
 * @author 
 */
@Data
public class CtmonGoods implements Serializable {
    private Integer goodsId;

    private Integer catId;

    private Integer brandId;

    private Integer goodsType;

    private String goodsSn;

    private String goodsName;

    private String goodsSubname;

    private Integer clickCount;

    private Integer goodsNumber;

    private Integer warnNumber;

    private BigDecimal goodsWeight;

    private String weightUnit;

    private BigDecimal marketPrice;

    private BigDecimal shopPrice;

    private BigDecimal promotePrice;

    private Date promoteStartDate;

    private Date promoteEndDate;

    private String tag;

    private String goodsDesc;

    private String goodsContent;

    private String goodsThumb;

    private String goodsImg;

    private String infoImg;

    private String originalImg;

    private String goodsVideo;

    private String infoTlp;

    private Boolean isOnSale;

    private Boolean isAloneSale;

    private Integer integral;

    private Date addTime;

    private Date lastUpdate;

    private Integer sortOrder;

    private Boolean isDelete;

    private Boolean isBest;

    private Boolean isNew;

    private Boolean isHot;

    private Boolean isSpecials;

    private Boolean isImport;

    private Boolean isPromote;

    private Integer giveIntegral;

    private Integer lowestQuantity;

    private Integer maxQuantity;

    private String urlrewriter;

    private String pagetitle;

    private String pagekeywords;

    private String pagedesc;

    private String goodsRelation;

    private String upType;

    private Boolean isMobile;

    private String goodsGg;

    private String downId;

    private String goodsYy;

    private Boolean isMoren;

    private static final long serialVersionUID = 1L;
}