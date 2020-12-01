package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_download_category
 * @author 
 */
@Data
public class CtmonDownloadCategory implements Serializable {
    private Integer catId;

    private Integer parentId;

    private Integer catType;

    private String catName;

    private String keywords;

    private String catDesc;

    private Integer sortOrder;

    private Integer catLevel;

    private String templateFile;

    private String templateDetailPath;

    private Boolean showInNav;

    private Boolean isReview;

    private Boolean isShow;

    private Integer grade;

    private String urlrewriter;

    private Boolean childOpen;

    private String ico;

    private Integer articlePhotoHeight;

    private Integer articlePhotoWidth;

    private String linkUrl;

    private Integer pagesize;

    private String pagetitle;

    private String pagekeywords;

    private String pagedesc;

    private static final long serialVersionUID = 1L;
}