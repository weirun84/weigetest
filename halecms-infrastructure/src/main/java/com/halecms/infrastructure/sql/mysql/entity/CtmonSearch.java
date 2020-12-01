package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_search
 * @author 
 */
@Data
public class CtmonSearch implements Serializable {
    private Integer searchId;

    private String title;

    private String des;

    private String contents;

    private String photo;

    private Integer type;

    private Date date;

    private Integer clickCount;

    private Integer typeId;

    private Boolean isDelete;

    private String tag;

    private static final long serialVersionUID = 1L;
}