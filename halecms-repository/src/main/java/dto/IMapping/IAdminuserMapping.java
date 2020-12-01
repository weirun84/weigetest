package dto.IMapping;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminuser;
import com.halecms.infrastructure.tool.opslab.util.Mpping.BaseMapping;
import dto.CtmonAdminuserDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAdminuserMapping extends BaseMapping<CtmonAdminuser, CtmonAdminuserDto> {

    @Mapping(target = "addTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "lastLogin", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Override
    CtmonAdminuserDto sourceToTarget(CtmonAdminuser var1);



    @Mapping(target = "addTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "lastLogin", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Override
    CtmonAdminuser targetToSource(CtmonAdminuserDto var1);


}
