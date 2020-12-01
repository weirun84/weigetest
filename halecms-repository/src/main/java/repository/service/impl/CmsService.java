package repository.service.impl;

import com.halecms.infrastructure.sql.mysql.MybatisUtil;
import com.halecms.infrastructure.sql.mysql.dao.CtmonCmsDao;
import org.springframework.stereotype.Component;
import repository.service.ICmsService;

@Component("CmsService")
public class CmsService implements ICmsService {
    @Override
    public int GetCmsCount()
    {
        CtmonCmsDao CmsDao= (CtmonCmsDao) MybatisUtil.getMapper(CtmonCmsDao.class);
        Integer Cmscount=CmsDao.GetCmsCount();
        return Cmscount;
    }
}
