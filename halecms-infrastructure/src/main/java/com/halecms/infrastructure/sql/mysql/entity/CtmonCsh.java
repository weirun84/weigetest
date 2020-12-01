package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_csh
 * @author 
 */
@Data
public class CtmonCsh implements Serializable {
    private Integer cshId;

    private String cshTitle;

    private String cshCon;

    private String cshPic;

    private Integer cshType;

    private Integer cshOrder;

    private static final long serialVersionUID = 1L;
}