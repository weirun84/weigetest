package repository.service;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminuser;
import com.halecms.infrastructure.sql.mysql.page.Pager;
import dto.CtmonAdminuserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IAdminUserService {
    int AddAdminUser(CtmonAdminuserDto record);

    int DelAdminUser(int id);

    int DelAdminUser(List<CtmonAdminuserDto> id);

    int UpdateAdminUser(CtmonAdminuserDto record);

    int DelAdminUserInfo(CtmonAdminuserDto id);

    CtmonAdminuserDto GetAdminUserInfo(int id);

    List<CtmonAdminuserDto> GetAdminUserPower(int id);

    Pager<CtmonAdminuserDto> PageAdminUser(int currPage, int pageSize, CtmonAdminuserDto friend);
}
