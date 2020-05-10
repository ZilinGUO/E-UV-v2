package com.gl52.euv.controller;

import com.gl52.euv.pojo.User;
import com.gl52.euv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/User")
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping("/toLogin.do")
//    @ResponseBody ,@RequestParam Map<String, Object> map
    @PostMapping(value = "/toLogin.do")
    public String doLogin(HttpSession session, @RequestParam("userName") String userName, @RequestParam("password")String password, Map<String, Object> map) {
      //  String userName = map.get("userName").toString();
        //String password = map.get("password").toString();

        if(!StringUtils.isEmpty(userName)&&!StringUtils.isEmpty(password)) {
            User dbUser = userService.identify(userName, password);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("redirect:/Uesr/index.do");
            if (dbUser == null) {
                map.put("msg","Le nom d\'utilisateur ou le mot de passe est incorrect");
                return "login";

            } else {
                session.setAttribute("role", dbUser.getRole());
                session.setAttribute("userId", dbUser.getId());
                session.setAttribute("userName", dbUser.getUserName());
                return "redirect:/main.html";
            }
        }

        return "login";
    }


    @RequestMapping(value = "/getUserInfo.do")
    @ResponseBody
    public String getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        Object id=request.getSession().getAttribute("userName");
        return (String) id;
    }

}
