package com.halecms.infrastructure.tool.opslab.util.CommonReturn;

import com.halecms.infrastructure.sql.mysql.page.Pager;

public class ControllerExt {

    /// <summary>
    /// cuowu 对象
    /// </summary>
    /// <param name="apiController"></param>
    /// <param name="result"></param>
    /// <returns></returns>
    public static Object ResponseErrorMessage(String message)
    {
        //AdminResponse AdminRes=new AdminResponse();
        return WebActionHelper.CreateCommonStringResponse(0,message);
    }

    /// <summary>
    /// cuowu 对象
    /// </summary>
    /// <param name="apiController"></param>
    /// <param name="result"></param>
    /// <returns></returns>
    public static Object ResponseSuccessMessage(String message)
    {
        return WebActionHelper.CreateCommonStringResponse(1,message);
    }

    /// <summary>
    /// cuowu 对象
    /// </summary>
    /// <param name="apiController"></param>
    /// <param name="result"></param>
    /// <returns></returns>
    public static Object ResponseObject(Object result)
    {
        return WebActionHelper.CreateCommonResponse(result);
    }
    /// <summary>
    /// cuowu 对象
    /// </summary>
    /// <param name="apiController"></param>
    /// <param name="result"></param>
    /// <returns></T
    public static<T> Object ResponsePageList(Pager<T> result)
    {
        return WebActionHelper.CreatePageListResponse(result.getRows(), result.getTotal());
    }
}
