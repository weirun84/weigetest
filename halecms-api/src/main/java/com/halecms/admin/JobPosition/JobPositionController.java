package com.halecms.admin.JobPosition;

import com.halecms.infrastructure.sql.mysql.page.Pager;
import com.halecms.infrastructure.tool.opslab.util.CommonReturn.ActionCommonReturnObject;
import com.halecms.infrastructure.tool.opslab.util.CommonReturn.ControllerExt;
import core.base.BaseController;
import dto.JobDepartmentDto;
import dto.JobpositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.service.IJobDepartmentService;
import repository.service.IJobPositionService;

import java.util.List;

@RestController
public class JobPositionController extends BaseController {
    @Autowired
    protected IJobPositionService _JobPositionService;
    @Autowired
    protected IJobDepartmentService _JobDepartmentService;

    @RequestMapping(value ="/adminpage/JobPosition/Add", method = {RequestMethod.GET})
    public ModelAndView Add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/JobPosition/add");
        List<JobDepartmentDto> jdlist=_JobDepartmentService.GetJobDepartmentAll("");
        modelAndView.addObject("JobDepartment",jdlist);
        return modelAndView;
    }

    @PostMapping("/adminpage/JobPosition/Add")
    @GetMapping("serializeJsonIgnoreProperties")
    public Object Add(JobpositionDto Jobpositio) {
        int result=_JobPositionService.AddJobPosition(Jobpositio);

        if (result==1)
        {
            return ControllerExt.ResponseErrorMessage("修改管理员成功");
        }
        else
        {
            return ControllerExt.ResponseErrorMessage("修改管理员失败");
        }
    }
    @RequestMapping(value ="/adminpage/JobPosition/List", method = {RequestMethod.GET})
    public ModelAndView List() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/JobPosition/list");//adminuserid
        List<JobDepartmentDto> jdlist=_JobDepartmentService.GetJobDepartmentAll("");
        modelAndView.addObject("JobDepartment",jdlist);
        return modelAndView;
    }
    @PostMapping("/adminpage/JobPosition/List")
    @GetMapping("serializeJsonIgnoreProperties")
    public ActionCommonReturnObject<Pager<JobpositionDto>> List(int pagesize, int pagenumber) {
        JobpositionDto Jobposition=null;
        Pager<JobpositionDto> pagerlist= _JobPositionService.PageJobPosition(pagenumber,pagesize,Jobposition);
        ActionCommonReturnObject<Pager<JobpositionDto>> res=(ActionCommonReturnObject<Pager<JobpositionDto>> ) ControllerExt.ResponsePageList(pagerlist);
        return res;
    }
    @RequestMapping(value ="/adminpage/JobPosition/Edit", method = {RequestMethod.GET})
    public ModelAndView Edit(int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/JobPosition/edit");
        JobpositionDto Jobposition=_JobPositionService.GetJobPositionInfo(id);
        modelAndView.addObject("Jobposition",Jobposition);
        return modelAndView;
    }
    @PostMapping("/adminpage/JobPosition/Edit")
    @GetMapping("serializeJsonIgnoreProperties")

    public Object Edit(JobpositionDto Jobposition) {
        JobpositionDto Jobpositioninfo=_JobPositionService.GetJobPositionInfo(Jobposition.getPositionId());

        int result=_JobPositionService.UpdateJobPosition(Jobpositioninfo);
        if (result==1)
        {
            return ControllerExt.ResponseErrorMessage("修改管理员成功");
        }
        else
        {
            return ControllerExt.ResponseErrorMessage("修改管理员失败");
        }
    }

    @PostMapping("/adminpage/JobPosition/Delete")
    @GetMapping("serializeJsonIgnoreProperties")
    public Object Delete(JobpositionDto Jobposition) {
        int result=0;
        result=_JobPositionService.DelJobPositionInfo(Jobposition);
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
