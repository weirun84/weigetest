package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_navigate
 * @author 
 */
@Data
public class CtmonNavigate implements Serializable {
    private Integer id;

    private String name;

    private Boolean isshow;

    private Integer vieworder;

    private Boolean opennew;

    private String url;

    private String type;

    private Boolean issystem;

    private Boolean isMobile;

    private String mobileIco;

    private Integer parentId;

    private String wxurl;

    private String ico;

    private Integer navTypeid;

    private Integer navId;

    private static final long serialVersionUID = 1L;
}