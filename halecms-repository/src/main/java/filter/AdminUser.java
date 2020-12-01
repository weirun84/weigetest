package filter;

import com.halecms.infrastructure.sql.mysql.MybatisUtil;
import com.halecms.infrastructure.sql.mysql.dao.CtmonAdminlogDao;
import com.halecms.infrastructure.sql.mysql.dao.CtmonAdminuserDao;
import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminlog;
import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminuser;
import com.halecms.infrastructure.tool.opslab.helper.*;
import dto.CtmonAdminuserDto;
import dto.IMapping.IAdminuserMapping;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

public class AdminUser {
    /// <summary>
    /// Session中后台管理员帐号
    /// </summary>
    public static String sessionAdminNameKey = "AdminName";

    /// <summary>
    /// Session中后台管理员ID
    /// </summary>
    public static String sessionAdminIDKey = "AdminID";

    /// <summary>
    /// Session中后台管理员是否是超级管理员Key
    /// </summary>
    public static String sessionIsSupperAdminKey = "IsSupperAdmin";

    /// <summary>
    /// Session中管理员权限
    /// </summary>
    public static String sessionAdminPowerKey = "AdminPower";

    /// <summary>
    /// Session中管理员后台日志ID，本次日志Key
    /// </summary>
    private static String sessionAdminLogIDKey = "AdminLogID";

    /// <summary>
    /// Cookies中后台管理员帐号Key
    /// </summary>
    private static String cookiesAdminNameKey = "AdminName";

    /// <summary>
    /// cookie 中后台管理员ID Key
    /// </summary>
    private static String cookiesAdminIDKey = "AdminID";

    /// <summary>
    /// cookie 中后台管理员信息，加密信息
    /// </summary>
    private static String cookiesAdminInfoKey = "AdminInfo";

    private static String cookiesAdminLogIDKey = "AdminLogID";
    private static String  secretKey="weige";
    @Resource
    private static IAdminuserMapping _IAdminuserMapping;
    /// <summary>
    /// 获取管理员信息
    /// </summary>
    /// <returns>当前管理员实体</returns>
    public static CtmonAdminuserDto GetMyInfo(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response)
    {
        if (IsAdminLogin(request,response))
        {
            String adminID = WebHelper.filter(CookieHelper.getCookie(request,cookiesAdminIDKey));//ID
            Integer aid=Integer.parseInt(CryptoHelper.dseDecode(secretKey,adminID));
            CtmonAdminuserDao Adminuser= (CtmonAdminuserDao) MybatisUtil.getMapper(CtmonAdminuserDao.class);
            //全不为空则判断信息是否正确
            CtmonAdminuser model = Adminuser.selectByPrimaryKey(aid);
            CtmonAdminuserDto _CtmonAdminuser = _IAdminuserMapping.sourceToTarget(model);
            return _CtmonAdminuser;
        }
        else
        {
            return null;
        }
    }
    /// <summary>
    /// 后台管理员登录
    /// </summary>
    /// <param name="userName">用户名</param>
    /// <param name="passWord">密码</param>
    /// <returns>是否登录成功</returns>
    public static boolean AdminLogin(String userName, String passWord,javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response)
    {
        if (userName.isEmpty() || passWord.isEmpty()) {
            return false;
        }
        String error = "";
        Date addtime= null;
        try {
            addtime = DateHelper.dateTime(DateHelper.currentTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userName = WebHelper.filter(userName);
        passWord = WebHelper.filter(passWord);
        //Guid GUID = Guid.NewGuid();
        CtmonAdminuserDao Adminuser= (CtmonAdminuserDao) MybatisUtil.getMapper(CtmonAdminuserDao.class);
        //全不为空则判断信息是否正确
        CtmonAdminuser entity = Adminuser.GetAdminUserInfo(userName);

        CtmonAdminlog log = new CtmonAdminlog();
        //log.GUID = GUID.ToString();
        log.setLogType(0);
        String ip= RequestHelper.getIpAddr(request);
        log.setIpAddress(ip);
        log.setLogTime(addtime);
        log.setUserName(userName);

        if (entity == null)
        {
            error = "登录失败：用户名或密码错误。";
            return false;
        }
        else
        {
            if (entity.getPassword() != CryptoHelper.md5(entity.getSalt() + passWord))
            {
                error = "登录失败：用户名或密码错误。";

                return false;
            }
            else
            {
                log.setUserId(entity.getUserId());
                entity.setLastLogin(addtime);
                Adminuser.updateByPrimaryKey(entity);
                //添加到记录
                CtmonAdminlogDao adminlogDao= (CtmonAdminlogDao) MybatisUtil.getMapper(CtmonAdminlogDao.class);
                //全不为空则判断信息是否正确
                Integer logid = adminlogDao.insert(log);
                //写入Session 和 Cookies
                //SessionHelper.WriteSession("rtadminguid", GUID.ToString());
                //CookiesHelper.WriteCookie("rtadminguid", GUID.ToString(), 120);
                AdminUserCookie adminuser=new AdminUserCookie();

                adminuser.setAdminID(entity.getUserId().toString());
                adminuser.setAdminLogID(logid.toString());
                adminuser.setAdminName(entity.getUserName());
                adminuser.setAdminPower("");
                adminuser.setAdminPwd(entity.getPassword());
                adminuser.setAdminSalt(entity.getSalt());
                //重新写入Session 和 Cookies
                SetAdminInfo(adminuser,request,response);

                return true;
            }
        }

    }
    public static boolean IsAdminLogin(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response)
    {
        String adminName = (String) request.getSession().getAttribute(sessionAdminNameKey);//用户名
        String adminID =  (String) request.getSession().getAttribute(sessionAdminIDKey);//ID
        //如果Session失效，则用Cookies判断
        if (adminName.isEmpty() || adminID.isEmpty())
        {

            String cooAdminName = WebHelper.filter(CookieHelper.getCookie(request,cookiesAdminNameKey));//用户名
            String cooAdminID = WebHelper.filter(CookieHelper.getCookie(request,cookiesAdminIDKey));//ID
            String cooLoginInfo = CookieHelper.getCookie(request,cookiesAdminInfoKey);//信息
            String cooAdminLogID = WebHelper.filter(CookieHelper.getCookie(request,cookiesAdminLogIDKey));//日志GUID


            if (cooAdminID.isEmpty() || cooAdminName.isEmpty() || cooLoginInfo.isEmpty() || cooAdminLogID.isEmpty())
            {
                return false;//信息不完整
            }
            else
            {
                Integer aid=Integer.parseInt(CryptoHelper.dseDecode(secretKey,cooAdminID));
                CtmonAdminuserDao Adminuser= (CtmonAdminuserDao) MybatisUtil.getMapper(CtmonAdminuserDao.class);
                //全不为空则判断信息是否正确
                CtmonAdminuser model = Adminuser.selectByPrimaryKey(aid);
                if (model == null)
                {
                    return false;//找不到管理员
                }
                else
                {
                    String md5password=CryptoHelper.md5(model.getUserName()+model.getPassword()+model.getSalt());
                    if (md5password == cooLoginInfo)
                    {
                        //信息正确，重建session
                        //获取日志ID
                        CtmonAdminlogDao Adminuserlog= (CtmonAdminlogDao) MybatisUtil.getMapper(CtmonAdminlogDao.class);
                        //全不为空则判断信息是否正确
                        CtmonAdminlog _Adminuserlog = Adminuserlog.selectByPrimaryKey(Integer.parseInt(cooAdminLogID));
                        if (_Adminuserlog == null)
                        {
                            ClearInfo(request,response);//清除信息
                            return false;//日志出错
                        }
                        AdminUserCookie adminuser=new AdminUserCookie();

                        adminuser.setAdminID(CryptoHelper.desEncrypt(secretKey,model.getUserId().toString()));
                        adminuser.setAdminLogID(cooAdminLogID);
                        adminuser.setAdminName(model.getUserName());
                        adminuser.setAdminPower("");
                        adminuser.setAdminPwd(model.getPassword());
                        adminuser.setAdminSalt(model.getSalt());
                        //重新写入Session 和 Cookies
                        SetAdminInfo(adminuser,request,response);
                        return true;
                    }
                    else
                    {
                        ClearInfo(request,response);//清除信息
                        return false;//信息错误
                    }

                }

            }
        }
        else
        {
            return true;//Session未失效，正确
        }
    }
    public static void SetAdminInfo(AdminUserCookie adminuser,javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response)
    {
        //写入 session
        request.getSession().setAttribute(sessionAdminIDKey,adminuser.getAdminID());
        request.getSession().setAttribute(sessionAdminNameKey,adminuser.getAdminName());
        request.getSession().setAttribute(sessionAdminPowerKey,adminuser.getAdminPower());
        request.getSession().setAttribute(sessionIsSupperAdminKey,adminuser.getIsSupperAdmin());
        request.getSession().setAttribute(sessionAdminLogIDKey,adminuser.getAdminLogID());
        //写入cookie
        String md5pass=CryptoHelper.md5(adminuser.getAdminName()+adminuser.getAdminPwd()+adminuser.getAdminSalt());
        CookieHelper.setCookie(response,cookiesAdminIDKey,adminuser.getAdminID(),"/adminpage/");
        CookieHelper.setCookie(response,cookiesAdminNameKey,adminuser.getAdminName(),"/adminpage/");
        CookieHelper.setCookie(response,cookiesAdminIDKey,md5pass,"/adminpage/");
        CookieHelper.setCookie(response,cookiesAdminIDKey,adminuser.getAdminLogID(),"/adminpage/");

    }
    /// <summary>
    /// 管理员退出登录，清除信息
    /// </summary>
    public static void ClearInfo(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response)
    {
        //写入 session
        request.getSession().setAttribute(sessionAdminIDKey,null);
        request.getSession().setAttribute(sessionAdminNameKey,null);
        request.getSession().setAttribute(sessionAdminPowerKey,null);
        request.getSession().setAttribute(sessionIsSupperAdminKey,null);
        request.getSession().setAttribute(sessionAdminLogIDKey,null);

        //写入cookie
        CookieHelper.getCookie(request,response,cookiesAdminIDKey);
        CookieHelper.getCookie(request,response,cookiesAdminNameKey);
        CookieHelper.getCookie(request,response,cookiesAdminInfoKey);
        CookieHelper.getCookie(request,response,sessionAdminLogIDKey);
    }
}
