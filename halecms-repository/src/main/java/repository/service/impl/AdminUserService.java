package repository.service.impl;

import com.halecms.infrastructure.sql.mysql.MybatisUtil;
import com.halecms.infrastructure.sql.mysql.dao.CtmonAdminActionDao;
import com.halecms.infrastructure.sql.mysql.dao.CtmonAdminuserDao;
import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminAction;
import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminuser;
import com.halecms.infrastructure.sql.mysql.page.Pager;
import com.halecms.infrastructure.tool.opslab.helper.CookieHelper;
import com.halecms.infrastructure.tool.opslab.helper.CryptoHelper;
import com.halecms.infrastructure.tool.opslab.helper.DateHelper;
import com.halecms.infrastructure.tool.opslab.helper.RandomHelper;
import com.halecms.infrastructure.tool.opslab.util.CommonReturn.ControllerExt;
import com.halecms.infrastructure.tool.opslab.util.RequestUtils;
import dto.CtmonAdminuserDto;
import dto.IMapping.IAdminuserMapping;
import org.springframework.stereotype.Component;
import repository.service.IAdminUserService;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("AdminUserService")
public class AdminUserService implements IAdminUserService {

    @Resource
    private IAdminuserMapping _IAdminuserMapping;
    @Override
    public int AddAdminUser(CtmonAdminuserDto record){
        Date addtime= null;
        try {
            addtime = DateHelper.dateTime(DateHelper.currentDateTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        record.setAddTime(addtime);
        record.setNavList("0");
        record.setLangType("0");
        record.setAgencyId(0);
        record.setTodolist("");
        String setSalt=String.valueOf(RandomHelper.integer(1,1000));
        record.setSalt(setSalt);
        record.setActionList("");
        record.setPassword(CryptoHelper.md5(record.getSalt()+record.getPassword()));
        CtmonAdminuser _CtmonAdminuser = _IAdminuserMapping.targetToSource(record);
        CtmonAdminuserDao Adminuser= (CtmonAdminuserDao) MybatisUtil.getMapper(CtmonAdminuserDao.class);
        Integer restule=Adminuser.insert(_CtmonAdminuser);
        MybatisUtil.commit();
        return  restule;
    }
    @Override
    public int DelAdminUser(int id){
        CtmonAdminuserDao Adminuser= (CtmonAdminuserDao) MybatisUtil.getMapper(CtmonAdminuserDao.class);
        Integer restule=Adminuser.deleteByPrimaryKey(id);
        return  restule;
    }

    @Override
    public int DelAdminUser(List<CtmonAdminuserDto> id) {
        int result=0;
        CtmonAdminuserDao Adminuser= (CtmonAdminuserDao) MybatisUtil.getMapper(CtmonAdminuserDao.class);
        for(CtmonAdminuserDto infoid:id)
        {
            result=Adminuser.deleteByPrimaryKey(infoid.getUserId());
            MybatisUtil.commit();
        }
        return result;
    }
    @Override
    public int DelAdminUserInfo(CtmonAdminuserDto id) {
        int result=0;
        CtmonAdminuserDao Adminuser= (CtmonAdminuserDao) MybatisUtil.getMapper(CtmonAdminuserDao.class);
        if(id!=null)
        {
            result=Adminuser.deleteByPrimaryKey(id.getUserId());
            MybatisUtil.commit();
        }
        return result;
    }

    @Override
    public int UpdateAdminUser(CtmonAdminuserDto record){
        CtmonAdminuserDao Adminuser= (CtmonAdminuserDao) MybatisUtil.getMapper(CtmonAdminuserDao.class);
        CtmonAdminuser _CtmonAdminuser = _IAdminuserMapping.targetToSource(record);
        Integer restule=Adminuser.updateByPrimaryKey(_CtmonAdminuser);
        MybatisUtil.commit();
        return  restule;
    }
    @Override
    public CtmonAdminuserDto GetAdminUserInfo(int id){
        CtmonAdminuserDao Adminuser= (CtmonAdminuserDao) MybatisUtil.getMapper(CtmonAdminuserDao.class);
        CtmonAdminuser restule=Adminuser.selectByPrimaryKey(id);
        CtmonAdminuserDto _CtmonAdminuser = _IAdminuserMapping.sourceToTarget(restule);
        return  _CtmonAdminuser;
    }

    @Override
    public List<CtmonAdminuserDto> GetAdminUserPower(int id) {
        CtmonAdminActionDao Adminaction= (CtmonAdminActionDao) MybatisUtil.getMapper(CtmonAdminActionDao.class);
        List<CtmonAdminAction> restule=Adminaction.GetAllaction();
        //List<CtmonAdminuserDto> _CtmonAdminuser = _IAdminuserMapping.sourceToTarget(restule);
        return null;
    }

    @Override
    public Pager<CtmonAdminuserDto> PageAdminUser(int currPage, int pageSize, CtmonAdminuserDto friend){
        String where=" 1=1 ";
        Map<String, Object> data = new HashMap<String, Object>();
        if (friend != null)
        {
            where += RequestUtils.GetFilter(friend);//查询条件
        }

        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        data.put("condition", where);
        CtmonAdminuserDao Adminuser= (CtmonAdminuserDao) MybatisUtil.getMapper(CtmonAdminuserDao.class);
        List<CtmonAdminuser> restule=Adminuser.findByPager(data);
        List<CtmonAdminuserDto>_CtmonAdminuser = _IAdminuserMapping.sourceToTarget(restule);
        Pager<CtmonAdminuserDto> pager = new Pager<CtmonAdminuserDto>();
        pager.setRows(_CtmonAdminuser);
        pager.setTotal(Adminuser.count());
        return  pager;
    }

}
