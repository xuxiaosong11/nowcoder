package com.example.nowcoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @ClassName LoginController.java
 * @Description TODO
 * @createTime 2020年04月25日 16:59:00
 */
@Controller
public class RegisterController {


    @GetMapping("/register")
    public String registerTest() {

        return "/site/register";
    }
}
