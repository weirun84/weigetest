package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_cms_page
 * @author 
 */
@Data
public class CtmonCmsPage implements Serializable {
    private Integer pageId;

    private Integer parentId;

    private String title;

    private String content;

    private Boolean isShow;

    private Boolean showInNav;

    private String infoTlp;

    private String tag;

    private String urlrewriter;

    private Date addTime;

    private Integer clickCount;

    private String pagetitle;

    private String pagekeywords;

    private String pagedesc;

    private Integer orderId;

    private String des;

    private String entitle;

    private String mobileContent;

    private Integer adId;

    private String photo;

    private String wxcontent;

    private static final long serialVersionUID = 1L;
}