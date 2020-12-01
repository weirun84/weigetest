package com.halecms.admin.adminuser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminuser;
import com.halecms.infrastructure.sql.mysql.page.Pager;
import com.halecms.infrastructure.tool.opslab.helper.CryptoHelper;
import com.halecms.infrastructure.tool.opslab.util.CommonReturn.ActionCommonReturnObject;
import com.halecms.infrastructure.tool.opslab.util.CommonReturn.ControllerExt;
import core.base.BaseController;
import dto.CtmonAdminuserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.service.IAdminUserService;
import repository.service.IGoodService;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@RestController
public class AdminuserController extends BaseController {
    @Autowired
    protected IAdminUserService AdminUserService;
    @RequestMapping(value ="/adminpage/AdminUser/Add", method = {RequestMethod.GET})
    public ModelAndView Add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/adminuser/add");
        return modelAndView;
    }

    @PostMapping("/adminpage/AdminUser/Add")
    @GetMapping("serializeJsonIgnoreProperties")
    public Object Add(CtmonAdminuserDto Adminuser) {
        int result=AdminUserService.AddAdminUser(Adminuser);

        if (result==1)
        {
            return ControllerExt.ResponseErrorMessage("修改管理员成功");
        }
        else
        {
            return ControllerExt.ResponseErrorMessage("修改管理员失败");
        }
    }
    @RequestMapping(value ="/adminpage/AdminUser/List", method = {RequestMethod.GET})
    public ModelAndView List() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/adminuser/list");//adminuserid
        modelAndView.addObject("adminuserid",2);
        return modelAndView;
    }
    @PostMapping("/adminpage/AdminUser/List")
    @GetMapping("serializeJsonIgnoreProperties")
    public ActionCommonReturnObject<Pager<CtmonAdminuserDto>> List(int pagesize, int pagenumber) {
        CtmonAdminuserDto Adminuser=null;
        Pager<CtmonAdminuserDto> pagerlist= AdminUserService.PageAdminUser(pagenumber,pagesize,Adminuser);
        ActionCommonReturnObject<Pager<CtmonAdminuserDto>> res=(ActionCommonReturnObject<Pager<CtmonAdminuserDto>> ) ControllerExt.ResponsePageList(pagerlist);
        return res;
    }
    @RequestMapping(value ="/adminpage/AdminUser/Edit", method = {RequestMethod.GET})
    public ModelAndView Edit(int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/adminuser/edit");
        CtmonAdminuserDto adminuser=AdminUserService.GetAdminUserInfo(id);
        modelAndView.addObject("adminuser",adminuser);
        return modelAndView;
    }
    @PostMapping("/adminpage/AdminUser/Edit")
    @GetMapping("serializeJsonIgnoreProperties")

    public Object Edit(CtmonAdminuserDto Adminuser) {
        CtmonAdminuserDto adminuserinfo=AdminUserService.GetAdminUserInfo(Adminuser.getUserId());
        adminuserinfo.setEmail(Adminuser.getEmail());
        adminuserinfo.setPhone(Adminuser.getPhone());
        String passw= CryptoHelper.md5(adminuserinfo.getSalt() + Adminuser.getPassword());
        adminuserinfo.setPassword(passw);
        int result=AdminUserService.UpdateAdminUser(adminuserinfo);
        if (result==1)
        {
            return ControllerExt.ResponseErrorMessage("修改管理员成功");
        }
        else
        {
            return ControllerExt.ResponseErrorMessage("修改管理员失败");
        }
    }

    @PostMapping("/adminpage/AdminUser/Delete")
    @GetMapping("serializeJsonIgnoreProperties")
    public Object Delete(CtmonAdminuserDto Adminuser) {
        int result=0;
        result=AdminUserService.DelAdminUserInfo(Adminuser);
        if (result==1)
        {
            return ControllerExt.ResponseErrorMessage("删除管理员成功");
        }
        else
        {
            return ControllerExt.ResponseErrorMessage("删除管理员失败");
        }
    }
}
