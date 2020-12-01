package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_config
 * @author 
 */
@Data
public class CtmonConfig implements Serializable {
    private Integer id;

    private Integer parentId;

    private String name;

    private String code;

    private String type;

    private String tip;

    private Integer size;

    private String storeRange;

    private String storeDir;

    private String value;

    private Integer sortOrder;

    private Boolean isshow;

    private static final long serialVersionUID = 1L;
}