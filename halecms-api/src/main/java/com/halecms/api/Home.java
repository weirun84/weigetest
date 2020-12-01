package com.halecms.api;

import com.halecms.infrastructure.sql.mysql.MybatisUtil;
import com.halecms.infrastructure.sql.mysql.dao.CtmonAdDao;
import com.halecms.infrastructure.sql.mysql.entity.CtmonAd;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping("/api/hello")
    public String Hello() {

        CtmonAdDao tt= (CtmonAdDao) MybatisUtil.getMapper(CtmonAdDao.class);
        CtmonAd tw=tt.selectByPrimaryKey(34);
        return tw.getAdCode();
    }
}
