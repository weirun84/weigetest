package dto.IMapping;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminuser;
import com.halecms.infrastructure.sql.mysql.entity.CtmonJobdepartment;
import com.halecms.infrastructure.tool.opslab.util.Mpping.BaseMapping;
import dto.CtmonAdminuserDto;
import dto.JobDepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IJobDepartmentMapping extends BaseMapping<CtmonJobdepartment, JobDepartmentDto> {

    @Override
    JobDepartmentDto sourceToTarget(CtmonJobdepartment var1);




    @Override
    CtmonJobdepartment targetToSource(JobDepartmentDto var1);
}
