package com.halecms.infrastructure.tool.opslab.util;

import com.halecms.infrastructure.tool.opslab.helper.DateHelper;
import com.halecms.infrastructure.tool.opslab.helper.WebHelper;
import sun.util.calendar.LocalGregorianCalendar;

import java.text.ParseException;
import java.util.Date;

public class RestructureRequest {
    private  static javax.servlet.http.HttpServletRequest request;
    /// <summary>
    /// 过滤后取得post提交表单值
    /// </summary>
    /// <param name="objid"></param>
    /// <returns></returns>
    public static  String getForm( String objName)
    {
        return WebHelper.filter(request.getParameter(objName));
    }
    /// <summary>
    /// 没有过滤取得post提交表单值
    /// </summary>
    /// <param name="objid"></param>
    /// <returns></returns>
    public static String getNVForm(String objName)
    {
        return request.getParameter(objName);
    }
    /// <summary>
    /// 取得post提交表单值
    /// </summary>
    /// <param name="objName"></param>
    /// <returns></returns>
    public static int getFormInt(String objName)
    {
        try {
            return Integer.parseInt(request.getParameter(objName));
        }
        catch (Exception e)
        {
            return 0;
        }

    }
    /// <summary>
    /// 取得post提交表单值
    /// </summary>
    /// <param name="objName"></param>
    /// <returns></returns>
    public static double getFormDecimal(String objName)
    {
        try {
            return Double.valueOf(request.getParameter(objName));
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    /// <summary>
    /// 取得post提交表单值
    /// </summary>
    /// <param name="objName"></param>
    /// <returns></returns>
    public static boolean getFormBoolean(String objName)
    {
        try {
            return Boolean.valueOf(request.getParameter(objName));
        }
        catch (Exception e)
        {
            return false;
        }
    }
    /// <summary>
    /// 取得post提交表单值
    /// </summary>
    /// <param name="objName"></param>
    /// <returns></returns>
    public static Date getFormDateTime(String objName)
    {
        Date time= null;
        if (request.getParameter(objName).isEmpty())
        {
            return null;
        }

        try {
            time= DateHelper.dateTime(request.getParameter(objName));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

}
