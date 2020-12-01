package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_cms_cat
 * @author 
 */
@Data
public class CtmonCmsCat implements Serializable {
    private Integer catId;

    private Integer parentId;

    private String catName;

    private Integer catType;

    private Integer contentType;

    private Boolean showInNav;

    private Boolean isReview;

    private String catPath;

    private Integer catLevel;

    private Integer sortOrder;

    private Integer pageSize;

    private String listTlp;

    private String infoTlp;

    private String urlrewriter;

    private String pagetitle;

    private String pagekeywords;

    private String pagedesc;

    private String pic;

    private String ms;

    private Boolean isMobile;

    private String enCatName;

    private static final long serialVersionUID = 1L;
}