package com.example.nowcoder.service;

import com.example.nowcoder.dao.UserMapper;
import com.example.nowcoder.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @ClassName UserServiceImol.java
 * @Description TODO
 * @createTime 2020年04月25日 11:34:00
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User selectById(int id) {
        return userMapper.selectById(id);
    }
}
