package repository.service.impl;

import com.halecms.infrastructure.sql.mysql.MybatisUtil;
import com.halecms.infrastructure.sql.mysql.dao.CtmonGoodsDao;
import org.springframework.stereotype.Component;
import repository.service.IGoodService;

@Component("GoodService")
public class GoodService implements IGoodService {
    @Override
    public int GetGoodsCount()
    {
        CtmonGoodsDao GoodsDao= (CtmonGoodsDao) MybatisUtil.getMapper(CtmonGoodsDao.class);
        Integer Goodcount=GoodsDao.GetGoodsCount();
        return  Goodcount;
    }
}
