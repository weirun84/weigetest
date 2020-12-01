package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_admin_menu
 * @author 
 */
@Data
public class CtmonAdminMenu implements Serializable {
    private Integer menuId;

    private Integer parentId;

    private String name;

    private String link;

    private Integer type;

    private Boolean isshow;

    private static final long serialVersionUID = 1L;
}