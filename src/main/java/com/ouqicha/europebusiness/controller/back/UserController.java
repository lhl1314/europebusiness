package com.ouqicha.europebusiness.controller.back;

import com.ouqicha.europebusiness.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/back")
@Controller
public class UserController  extends BaseController {

    @RequestMapping("/login")
    public ModelAndView login(String name, String password){
        ModelAndView mav = new ModelAndView();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            mav.setViewName("redirect:/home.jsp");//shiro login有问题不会执行到这里，如果放在try外就有问题
        }catch (Exception e){
            e.printStackTrace();
        }

        return mav;
    }

    /***
     * 跳转到登录页面
     *
     * @return
     */
     @RequestMapping(value = "/tologin")
     public String toLogin() {
         // 跳转到/page/login.jsp页面
         return "login";
     }
}
