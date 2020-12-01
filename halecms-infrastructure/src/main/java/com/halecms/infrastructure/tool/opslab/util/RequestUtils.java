package com.halecms.infrastructure.tool.opslab.util;

import com.sun.net.httpserver.HttpsServer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RequestUtils {
    private static javax.servlet.http.HttpServletRequest request;
    /// <summary>
    /// 获取查询条件
    /// </summary>
    /// <returns></returns>
    public static  <T> String GetFilter(T classz)
    {
        String filter = "";
        String field = RestructureRequest.getForm("field"),
                target = RestructureRequest.getForm("target"),
                val = RestructureRequest.getForm("val");
        Field[] fields = classz.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            try {
                // 对于每个属性，获取属性名
                String varName = fields[i].getName();
                // 获取原来的访问控制权限
                //boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                //fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object values = getFieldValueByName(varName, classz);
                //System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                // 恢复访问控制权限
                //fields[i].setAccessible(accessFlag);
                if (!val.isEmpty()) {
                    if (target == "istext" && field == varName) {
                        filter += " and " + varName + "='" + val + "'";
                    }
                    if (target == "isnum"  && field == varName)
                    {filter += " and " + varName + "=" + val + "";}
                    if (target == "like" && field == varName)
                    { filter += " and " + varName + " like '%" + val + "%'";}
                    if (target == "gt"  && field == varName)
                    {  filter += " and " + varName + ">=" + val + "";}
                    if (target == "lt"  && field == varName)
                    {filter += " and " + varName + "<=" + val + "";}
                    if (values != null)
                    {
                        if ((int) values != 0) {
                            filter += " and " + varName + "= true";
                        }

                    }
                }
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
        return filter;
    }
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            System.out.println("属性不存在");
            return null;
        }
    }
    /// <summary>
    /// 获取排序
    /// </summary>
    /// <param name="defaultOrder"></param>
    /// <returns></returns>
    public static String GetSortOrder(String defaultOrder)
    {
        String order = defaultOrder;
        if (!RestructureRequest.getForm("sort_by").isEmpty()&& ! RestructureRequest.getForm("sort_order").isEmpty())
        {
            order =  RestructureRequest.getForm("sort_by") + " " +  RestructureRequest.getForm("sort_order");
        }

        return order;
    }
}
