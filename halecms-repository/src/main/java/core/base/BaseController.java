package core.base;


import dto.CtmonAdminuserDto;
import filter.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import repository.service.IAdminUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController  {

    /// <summary>
    /// 后台用户实体类
    /// </summary>
    public CtmonAdminuserDto AdminUserInfo = new CtmonAdminuserDto();
    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;
    /**
     * 获取用户信息
     *
     * @return
     */
    protected CtmonAdminuserDto getAdminUser() {
        CtmonAdminuserDto user = AdminUser.GetMyInfo(request,response);
        if (StringUtils.isEmpty(user)) {
            return null;
        } else {
            return user;
        }
    }
}
