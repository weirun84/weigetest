package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_download
 * @author 
 */
@Data
public class CtmonDownload implements Serializable {
    private Integer downId;

    private String title;

    private String keywords;

    private String content;

    private Date inputtime;

    private Boolean isEnable;

    private Integer orderid;

    private String url;

    private Integer rank;

    private String author;

    private String source;

    private String des;

    private String photo;

    private String filesize;

    private String filename;

    private Integer clickCount;

    private String urlrewriter;

    private Integer catId;

    private Boolean isTop;

    private String seokeyword;

    private String seodesc;

    private String templateFile;

    private Date showtime;

    private Integer isReco;

    private String softLan;

    private String provider;

    private String softAuthorize;

    private String platform;

    private Integer noReco;

    private String pagetitle;

    private String pagekeywords;

    private String pagedesc;

    private static final long serialVersionUID = 1L;
}