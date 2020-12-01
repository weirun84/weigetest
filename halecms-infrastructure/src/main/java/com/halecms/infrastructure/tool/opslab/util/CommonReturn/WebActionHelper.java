package com.halecms.infrastructure.tool.opslab.util.CommonReturn;

public class WebActionHelper {
    /// <summary>
    /// 创建匿名的通用返回
    /// </summary>
    /// <typeparam name="T"></typeparam>
    /// <param name="AnonymousTypeObj"></param>
    /// <returns></returns>
    public static <T> ActionCommonReturnObject CreateCommonResponse(T AnonymousTypeObj)
    {
        ActionCommonReturnObject<T> commRlt = new ActionCommonReturnObject<T>(AnonymousTypeObj);
        return commRlt;
    }

    /// <summary>
    /// 创建string的通用返回
    /// </summary>
    /// <typeparam name="T"></typeparam>
    /// <param name="AnonymousTypeObj"></param>
    /// <returns></returns>
    public static <T> ActionCommonReturnObject CreateCommonStringResponse(int success, String message)
    {
        ActionCommonReturnObject<T> commRlt = new ActionCommonReturnObject<T>(success, message);
        return commRlt;
    }

    /// <summary>
    /// 创建分页的通用返回
    /// </summary>
    /// <typeparam name="T"></typeparam>
    /// <param name="AnonymousTypeObj"></param>
    /// <returns></returns>
    public static <T> ActionCommonReturnObject CreatePageListResponse(T AnonymousTypeObj,long total)
    {
        ActionCommonReturnObject<T> commRlt = new ActionCommonReturnObject<T>(AnonymousTypeObj, total);
        return commRlt;
    }
}
