package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ctmon_feedback
 * @author 
 */
@Data
public class CtmonFeedback implements Serializable {
    private Integer msgId;

    private Integer parentId;

    private Integer userId;

    private String userName;

    private String userEmail;

    private String msgTitle;

    private Integer msgType;

    private String msgContent;

    private Date msgTime;

    private String msgFile;

    private Integer orderId;

    private Boolean isShow;

    private String url;

    private String ip;

    private String userTel;

    private static final long serialVersionUID = 1L;
}