package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_ad_position
 * @author 
 */
@Data
public class CtmonAdPosition implements Serializable {
    private Integer positionId;

    private String positionName;

    private Integer adWidth;

    private Integer adHeight;

    private String positionDesc;

    private String positionStyle;

    private String positionUrl;

    private Integer positionType;

    private Boolean isShowText;

    private static final long serialVersionUID = 1L;
}