package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_lbs
 * @author 
 */
@Data
public class CtmonLbs implements Serializable {
    private Integer id;

    private String title;

    private Integer regionid;

    private Integer cityid;

    private Integer districtid;

    private String address;

    private String tel;

    private String pic;

    private String des;

    private String xposition;

    private String yposition;

    private String type;

    private Integer orderId;

    private static final long serialVersionUID = 1L;
}