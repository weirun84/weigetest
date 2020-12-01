package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_cms
 * @author 
 */
@Data
public class CtmonCms implements Serializable {
    private Integer articleId;

    private Integer catId;

    private String title;

    private String fuTitle;

    private String titleStyle;

    private String content;

    private String author;

    private String source;

    private String editor;

    private Boolean isTop;

    private Boolean isBest;

    private Boolean isHot;

    private String infoTlp;

    private Boolean isShow;

    private String tag;

    private Boolean isNewopen;

    private String link;

    private String photo;

    private String des;

    private String urlrewriter;

    private Date addTime;

    private Date showtime;

    private Integer clickCount;

    private String pagetitle;

    private String pagekeywords;

    private String pagedesc;

    private Integer sortOrder;

    private Boolean isMobile;

    private Boolean isOauth;

    private Integer cmsType;

    private String downId;

    private Integer isSinas;

    private Integer isToutiao;

    private Integer isXiongzhang;

    private static final long serialVersionUID = 1L;
}