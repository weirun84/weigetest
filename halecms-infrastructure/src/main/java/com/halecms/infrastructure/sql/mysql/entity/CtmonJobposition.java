package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_jobposition
 * @author 
 */
@Data
public class CtmonJobposition implements Serializable {
    private Integer positionId;

    private String name;

    private Integer number;

    private String content;

    private Integer departmentId;

    private Date enTime;

    private Integer sortOrder;

    private static final long serialVersionUID = 1L;
}