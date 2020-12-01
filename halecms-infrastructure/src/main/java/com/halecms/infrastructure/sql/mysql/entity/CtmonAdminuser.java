package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_adminuser
 * @author 
 */
@Data
public class CtmonAdminuser implements Serializable {
    private Integer userId;

    private String userName;

    private String email;

    private String password;

    private Date addTime;

    private Date lastLogin;

    private String lastIp;

    private String actionList;

    private String navList;

    private String langType;

    private Integer agencyId;

    private String todolist;

    private String salt;

    private String phone;

    private static final long serialVersionUID = 1L;
}