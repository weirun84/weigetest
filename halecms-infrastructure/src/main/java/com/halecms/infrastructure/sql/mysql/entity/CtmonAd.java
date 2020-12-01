package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_ad
 * @author 
 */
@Data
public class CtmonAd implements Serializable {
    private Integer adId;

    private Integer positionId;

    private Integer mediaType;

    private String adName;

    private String adLink;

    private String adCode;

    private Date startTime;

    private Date endTime;

    private String linkMan;

    private String linkEmail;

    private String phoneUrl;

    private Long clickCount;

    private Boolean enabled;

    private Integer orderid;

    private String des;

    private String videoUrl;

    private static final long serialVersionUID = 1L;
}