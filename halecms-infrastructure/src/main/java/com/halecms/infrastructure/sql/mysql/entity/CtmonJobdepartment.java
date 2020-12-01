package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_jobdepartment
 * @author 
 */
@Data
public class CtmonJobdepartment implements Serializable {
    private Integer departmentId;

    private String departmentName;

    private Integer sortOrder;

    private String urlrewriter;

    private String pagetitle;

    private String pagekeywords;

    private String pagedesc;

    private String listTlp;

    private String infoTlp;

    private Integer pageSize;

    private static final long serialVersionUID = 1L;
}