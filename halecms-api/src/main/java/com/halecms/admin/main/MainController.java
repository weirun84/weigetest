package com.halecms.admin.main;

import core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import repository.service.ICmsService;
import repository.service.IFeedbackService;
import repository.service.IGoodService;

@RestController
public class MainController  extends BaseController {
    @Autowired
    @Qualifier("GoodService")
    protected IGoodService GoodService;
    @Autowired
    @Qualifier("CmsService")
    protected ICmsService CmsService;
    @Autowired
    @Qualifier("FeedbackService")
    protected IFeedbackService FeedbackService;
    @RequestMapping("/adminpage/main.html")
    public ModelAndView Main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/main");
        Integer Goodcount=GoodService.GetGoodsCount();
        Integer Cmscount=CmsService.GetCmsCount();
        Integer Feedbackcount=FeedbackService.GetFeedbackCount();
        modelAndView.addObject("Goodcount",Goodcount);
        modelAndView.addObject("Cmscount",Cmscount);
        modelAndView.addObject("msgcount",Feedbackcount);
        return modelAndView;
    }
}
