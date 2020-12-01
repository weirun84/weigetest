package dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class JobDepartmentDto {
    private Integer departmentId;

    private String departmentName;

    private Integer sortOrder;

    private String urlrewriter;

    private String pagetitle;

    private String pagekeywords;

    private String pagedesc;

    private String listTlp;

    private String infoTlp;

    private Integer pageSize;
}
