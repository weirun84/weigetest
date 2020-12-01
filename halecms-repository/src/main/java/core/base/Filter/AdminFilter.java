package core.base.Filter;

import com.halecms.infrastructure.tool.opslab.util.CommonReturn.ControllerExt;
import filter.AdminUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@WebFilter(urlPatterns = "/adminpage/*", filterName = "AdminFilter")
public class AdminFilter implements Filter {
    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/login","register"};
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        //是否需要过滤
//        boolean needFilter = isNeedFilter(uri);
//        if (!needFilter) { //不需要过滤直接传给下一个过滤器
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else { //需要过滤器
//            boolean islogin = AdminUser.IsAdminLogin(request,response);
//            // session中包含user对象,则是登录状态
//            if(islogin){
//                // System.out.println("user:"+session.getAttribute("user"));
//                filterChain.doFilter(request, response);
//            }else{
//                String requestType = request.getHeader("X-Requested-With");
//                //判断是否是ajax请求
//                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
//                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
//                    out.writeObject(ControllerExt.ResponseErrorMessage("未登录"));
//
//                }else{
//                    //重定向到登录页(需要在static文件夹下建立此html文件)
//                    response.sendRedirect(request.getContextPath()+"/user/login.html");
//                }
//                return;
//            }
//        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
    /**
     * @Author: xxxxx
     * @Description: 是否需要过滤
     * @Date: 2018-03-12 13:20:54
     * @param uri
     */
    public boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }

        return true;
    }

}
