package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_cms_link
 * @author 
 */
@Data
public class CtmonCmsLink implements Serializable {
    private Integer linkId;

    private Integer cmsId;

    private Integer linkGoodsId;

    private Integer linkDowsloadId;

    private Boolean isDouble;

    private Integer adminId;

    private Integer type;

    private Integer linkCmsId;

    private static final long serialVersionUID = 1L;
}