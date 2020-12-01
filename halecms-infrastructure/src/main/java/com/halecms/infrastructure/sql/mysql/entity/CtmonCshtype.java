package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_cshtype
 * @author 
 */
@Data
public class CtmonCshtype implements Serializable {
    private Integer typeId;

    private String typeName;

    private static final long serialVersionUID = 1L;
}