package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_adminlog
 * @author 
 */
@Data
public class CtmonAdminlog implements Serializable {
    private Integer logId;

    private Date logTime;

    private Integer userId;

    private String userName;

    private String logInfo;

    private String ipAddress;

    private Integer logType;

    private static final long serialVersionUID = 1L;
}