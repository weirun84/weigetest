package repository.service.impl;

import com.halecms.infrastructure.sql.mysql.MybatisUtil;
import com.halecms.infrastructure.sql.mysql.dao.CtmonAdminuserDao;
import com.halecms.infrastructure.sql.mysql.dao.CtmonJobpositionDao;
import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminuser;
import com.halecms.infrastructure.sql.mysql.entity.CtmonJobposition;
import com.halecms.infrastructure.sql.mysql.page.Pager;

import com.halecms.infrastructure.tool.opslab.util.RequestUtils;
import dto.CtmonAdminuserDto;
import dto.IMapping.IJobPositionMapping;
import dto.JobpositionDto;
import org.springframework.stereotype.Component;
import repository.service.IJobPositionService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("JobPositionService")
public class JobPositionService implements IJobPositionService {
    @Resource
    private IJobPositionMapping _IJobPositionMapping;
    @Override
    public int AddJobPosition(JobpositionDto record) {
        CtmonJobposition _Jobposition = _IJobPositionMapping.targetToSource(record);
        CtmonJobpositionDao Jobposition= (CtmonJobpositionDao) MybatisUtil.getMapper(CtmonJobpositionDao.class);
        Integer restule=Jobposition.insert(_Jobposition);
        MybatisUtil.commit();
        return restule;
    }

    @Override
    public int DelJobPosition(int id) {
        CtmonJobpositionDao Jobposition= (CtmonJobpositionDao) MybatisUtil.getMapper(CtmonJobpositionDao.class);
        Integer restule=Jobposition.deleteByPrimaryKey(id);
        return restule;
    }

    @Override
    public int DelJobPosition(List<JobpositionDto> id) {
        int result=0;
        CtmonJobpositionDao Jobposition= (CtmonJobpositionDao) MybatisUtil.getMapper(CtmonJobpositionDao.class);
        for(JobpositionDto infoid:id)
        {
            result=Jobposition.deleteByPrimaryKey(infoid.getPositionId());
            MybatisUtil.commit();
        }
        return result;
    }

    @Override
    public int UpdateJobPosition(JobpositionDto record) {
        CtmonJobpositionDao Jobposition= (CtmonJobpositionDao) MybatisUtil.getMapper(CtmonJobpositionDao.class);
        CtmonJobposition _Jobposition = _IJobPositionMapping.targetToSource(record);
        Integer restule=Jobposition.updateByPrimaryKey(_Jobposition);
        MybatisUtil.commit();
        return  restule;
    }

    @Override
    public int DelJobPositionInfo(JobpositionDto id) {
        int result=0;
        CtmonJobpositionDao Jobposition= (CtmonJobpositionDao) MybatisUtil.getMapper(CtmonJobpositionDao.class);
        if(id!=null)
        {
            result=Jobposition.deleteByPrimaryKey(id.getPositionId());
            MybatisUtil.commit();
        }
        return result;
    }

    @Override
    public JobpositionDto GetJobPositionInfo(int id) {
        CtmonJobpositionDao Jobposition= (CtmonJobpositionDao) MybatisUtil.getMapper(CtmonJobpositionDao.class);
        CtmonJobposition restule=Jobposition.selectByPrimaryKey(id);
        JobpositionDto _Jobposition = _IJobPositionMapping.sourceToTarget(restule);
        return  _Jobposition;
    }



    @Override
    public Pager<JobpositionDto> PageJobPosition(int currPage, int pageSize, JobpositionDto friend) {
        String where=" 1=1 ";
        Map<String, Object> data = new HashMap<String, Object>();
        if (friend != null)
        {
            where += RequestUtils.GetFilter(friend);//查询条件
        }

        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        data.put("condition", where);
        CtmonJobpositionDao Jobposition= (CtmonJobpositionDao) MybatisUtil.getMapper(CtmonJobpositionDao.class);
        List<CtmonJobposition> restule=Jobposition.findByPager(data);
        List<JobpositionDto>_Jobposition = _IJobPositionMapping.sourceToTarget(restule);
        Pager<JobpositionDto> pager = new Pager<JobpositionDto>();
        pager.setRows(_Jobposition);
        pager.setTotal(Jobposition.count());
        return  pager;
    }
}
