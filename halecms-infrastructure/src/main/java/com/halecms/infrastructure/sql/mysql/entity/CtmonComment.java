package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_comment
 * @author 
 */
@Data
public class CtmonComment implements Serializable {
    private Integer commentId;

    private Integer commentType;

    private Integer idValue;

    private String email;

    private String userName;

    private String content;

    private Integer commentRank;

    private Date addTime;

    private String ipAddress;

    private Boolean enabled;

    private Integer parentId;

    private Integer userId;

    private Boolean isRead;

    private String url;

    private Boolean isRecomm;

    private static final long serialVersionUID = 1L;
}