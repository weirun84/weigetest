package repository.service.impl;

import com.halecms.infrastructure.sql.mysql.MybatisUtil;
import com.halecms.infrastructure.sql.mysql.dao.CtmonAdminMenuDao;
import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminMenu;

import org.springframework.stereotype.Component;
import repository.service.IAdminMenuService;

import java.util.List;

@Component("AdminMenuService")
public class AdminMenuService implements IAdminMenuService {
    @Override
    public List<CtmonAdminMenu> GetAdminMenuAll() {
        CtmonAdminMenuDao AdminMenuDao= (CtmonAdminMenuDao) MybatisUtil.getMapper(CtmonAdminMenuDao.class);
        List<CtmonAdminMenu> AdminMenuDaoList=AdminMenuDao.GetAdminMenuAll();
        return AdminMenuDaoList;
    }
}
