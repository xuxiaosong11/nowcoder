package com.example.nowcoder.controller;

import com.example.nowcoder.dao.UserMapper;
import com.example.nowcoder.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年04月24日 18:10:00
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/index1")
    public void select() {
        User user = userMapper.selectById(12);
        System.out.println(user);

    }
}
