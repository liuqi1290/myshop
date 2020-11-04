package com.liuqi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ApiIgnore
@Controller
public class SsoController {
    private  static Logger logger= LoggerFactory.getLogger(SsoController.class);
    @RequestMapping("login")
    public  String hellow(String returnUrl ,
                          Model model,
                          HttpServletRequest request,
                          HttpServletResponse response){
        model.addAttribute("returnUrl",returnUrl);
        //TODO  后续完善验证
        return "login";
    }


}
