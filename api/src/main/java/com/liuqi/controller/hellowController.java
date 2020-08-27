package com.liuqi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ApiIgnore
@RestController
public class hellowController {
    private  static Logger logger= LoggerFactory.getLogger(hellowController.class);
    @GetMapping("/hellow")
    public  Object hellow(HttpServletRequest request){
        logger.debug("debug`````");
        logger.info("info````");
        logger.warn("warn`````");
        logger.error("error````");
        HttpSession session = request.getSession();
        session.setAttribute("userInfo","00");
        return "hellow wold";
    }
}
