package com.halecms.infrastructure.sql.mysql.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ctmon_download_link
 * @author 
 */
@Data
public class CtmonDownloadLink implements Serializable {
    private Integer linkId;

    private Integer dowsloadId;

    private Integer linkGoodsId;

    private Boolean isDouble;

    private Integer likCmsId;

    private Integer type;

    private static final long serialVersionUID = 1L;
}