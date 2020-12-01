package com.halecms.admin;

import com.halecms.infrastructure.sql.mysql.entity.CtmonAdminMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import repository.service.IAdminMenuService;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    @Qualifier("AdminMenuService")
    protected IAdminMenuService AdminMenuService;

    @RequestMapping("/adminpage/index.html")
    public ModelAndView Index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/index");
        List<CtmonAdminMenu> AdminMenuDaoList=AdminMenuService.GetAdminMenuAll();
        modelAndView.addObject("MenuList",AdminMenuDaoList);
        return modelAndView;
    }

}
