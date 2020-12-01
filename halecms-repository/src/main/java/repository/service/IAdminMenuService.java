package repository.service;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IAdminMenuService {
    List<CtmonAdminMenu>  GetAdminMenuAll();
}
