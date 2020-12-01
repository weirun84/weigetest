package com.halecms.infrastructure.tool.opslab.util.CommonReturn;

import lombok.Data;

@Data
public class ActionCommonReturnObject<T> {
    public long total ;
    public int success ;
    public T Data ;
    public String Message ;
    public String Code;


    public ActionCommonReturnObject(T Data)
    {
        this.Data = Data;
        this.success = 0;
    }

    public ActionCommonReturnObject(T Data, long _total)
    {
        this.Data = Data;
        this.total = _total;
        this.success = 0;
    }

    public ActionCommonReturnObject(int success, String message)
    {
        this.success = 0;
        this.Message = message;
    }
}
