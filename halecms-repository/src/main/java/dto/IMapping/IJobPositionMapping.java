package dto.IMapping;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminuser;
import com.halecms.infrastructure.sql.mysql.entity.CtmonJobposition;
import com.halecms.infrastructure.tool.opslab.util.Mpping.BaseMapping;
import dto.CtmonAdminuserDto;
import dto.JobpositionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IJobPositionMapping extends BaseMapping<CtmonJobposition, JobpositionDto> {
    @Mapping(target = "enTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Override
    JobpositionDto sourceToTarget(CtmonJobposition var1);



    @Mapping(target = "enTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Override
    CtmonJobposition targetToSource(JobpositionDto var1);
}
