package com.liuqi.intercepter;

import com.liuqi.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import javax.swing.*;

public class UserTokenInpercepeter implements HandlerInterceptor{

    private  static final String REDIS_USER_TOKEN = "redis_user_token";

    private  static final String HEADERUSERID = "headerUserId";
    private  static final String HEADERUSERTOKEN = "headerUserToken";

    @Autowired
    private RedisOperator redisOperator;


    /**
     * 在访问contrller 之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //false  代表请求被拦截你
        //true  代表验证通过，可以继续
        System.out.println("进入拦截器");
        String headeruserId = request.getHeader(HEADERUSERID);
        String headerUserToken = request.getHeader(HEADERUSERTOKEN);
        if(StringUtils.isNotBlank(headeruserId) && StringUtils.isNotBlank(headerUserToken) ){
            String uniqueToken = redisOperator.get(REDIS_USER_TOKEN + ":" + headeruserId);
            if(StringUtils.isBlank(headeruserId)){
                System.out.println("请登录");
                return false;
            }else if(!headerUserToken.equals(uniqueToken)){
                System.out.println("账号可能异地登陆，请重新登录！");
                return false;
            }
        }else{
            System.out.println("请登录");
            return false;
        }


        return false;
    }

    /**
     * 请求contrller之后，渲染视图之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求contrller之后，渲染视图之后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
