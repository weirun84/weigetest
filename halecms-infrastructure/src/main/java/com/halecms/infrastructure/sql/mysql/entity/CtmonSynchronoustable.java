package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_synchronoustable
 * @author 
 */
@Data
public class CtmonSynchronoustable implements Serializable {
    private Integer id;

    private String title;

    private String language;

    private String tolanguage;

    private String conn;

    private static final long serialVersionUID = 1L;
}