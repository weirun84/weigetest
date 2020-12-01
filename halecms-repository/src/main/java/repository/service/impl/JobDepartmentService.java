package repository.service.impl;

import com.halecms.infrastructure.sql.mysql.MybatisUtil;
import com.halecms.infrastructure.sql.mysql.dao.CtmonAdminMenuDao;
import com.halecms.infrastructure.sql.mysql.dao.CtmonJobdepartmentDao;
import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminMenu;
import com.halecms.infrastructure.sql.mysql.entity.CtmonJobdepartment;
import dto.IMapping.IAdminuserMapping;
import dto.IMapping.IJobDepartmentMapping;
import dto.JobDepartmentDto;
import dto.JobpositionDto;
import org.springframework.stereotype.Component;
import repository.service.IJobDepartmentService;

import javax.annotation.Resource;
import java.util.List;
@Component("JobDepartmentService")
public class JobDepartmentService implements IJobDepartmentService {
    @Resource
    private IJobDepartmentMapping _IJobDepartmentMapping;
    @Override
    public List<JobDepartmentDto> GetJobDepartmentAll(String where) {
        String condition=" 1=1 ";
        condition+=where;
        CtmonJobdepartmentDao JobdepartmentDao= (CtmonJobdepartmentDao) MybatisUtil.getMapper(CtmonJobdepartmentDao.class);
        List<CtmonJobdepartment> _JobdepartmentDao=JobdepartmentDao.GetJobdepartment(condition);
        List<JobDepartmentDto> res = _IJobDepartmentMapping.sourceToTarget(_JobdepartmentDao);
        return res;
    }
}
