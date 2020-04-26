package com.example.nowcoder.controller;

import com.example.nowcoder.entiy.User;
import com.example.nowcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author admin
 * @ClassName LoginController.java
 * @Description TODO
 * @createTime 2020年04月25日 16:59:00
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;


    @GetMapping(path="/register")
    public String registerTest() {

        return "/site/register";
    }

    @PostMapping(path = "/register")
    public String registerTest2(Model model, User user) {
        Map<String, Object> regiest = userService.regiest(user);
        if (null==regiest || regiest.isEmpty()) {
            model.addAttribute("msg","你已经注册成功，请尽快激活邮件！");
            model.addAttribute("target","/");
            return "/site/operate-result";
        } else {
            model.addAttribute("usernameMsg",regiest.get("usernameMsg"));
            model.addAttribute("passwordMsg",regiest.get("passwordMsg"));
            model.addAttribute("emailMsg",regiest.get("emailMsg"));
            return "/site/register";
        }

    }

}
