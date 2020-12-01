package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_admin_action
 * @author 
 */
@Data
public class CtmonAdminAction implements Serializable {
    private Integer actionId;

    private Integer parentId;

    private String actionCode;

    private String actionText;

    private Boolean isenable;

    private static final long serialVersionUID = 1L;
}