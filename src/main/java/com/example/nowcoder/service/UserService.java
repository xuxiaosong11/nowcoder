package com.example.nowcoder.service;

import com.example.nowcoder.dao.UserMapper;
import com.example.nowcoder.entiy.User;
import com.example.nowcoder.util.CoummuntiyUtil;
import com.example.nowcoder.util.CoumuntiyConstant;
import com.example.nowcoder.util.MailClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author admin
 * @ClassName UserServiceImol.java
 * @Description TODO
 * @createTime 2020年04月25日 11:34:00
 */
@Service
public class UserService implements CoumuntiyConstant{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${nowcoder.path.domain}")
    private String domain;

    @Value("${server.servlet.context-path}")
    private String  path;

    public User selectById(int id) {
        return userMapper.selectById(id);
    }

    public Map<String ,Object> regiest(User user) {
        Map<String ,Object> map=new HashMap<>();
         if (user ==null) {
             throw  new IllegalArgumentException("参数不能为空");
         }
         if (StringUtils.isBlank(user.getUsername())) {
             map.put("usernameMsg","账号不能为空");
             return map;
         }
        if (StringUtils.isBlank(user.getPassword())) {
            map.put("passwordMsg","密码不能为空");
            return map;
        }
        if (StringUtils.isBlank(user.getEmail())) {
             map.put("emailMsg","邮箱不能为空");
             return map;
        }
        User u=userMapper.selectByName(user.getUsername());
         if (u !=null) {

             map.put("usernameMsg","账号已经存在");
             return map;
         }
         u=userMapper.selectByEmail(user.getEmail());
         if (u != null) {
             System.out.println(u);
             map.put("emailMsg","邮箱已被注册");
             return map;
         }
         user.setSalt(CoummuntiyUtil.generateUUID().substring(0,5));
         user.setPassword(CoummuntiyUtil.md5(user.getPassword()+user.getSalt()));
         user.setType(0);
         user.setStatus(0);
         user.setActivation_code(CoummuntiyUtil.generateUUID());
         user.setHeader_url(String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000)));
        user.setCreate_time(new Date());
        int i = userMapper.insertUser(user);
        Context context=new Context();
        context.setVariable("email",user.getEmail());
        String url=domain+path+"activation"+"/"+user.getId()+"/"+user.getActivation_code();
        context.setVariable("url",url);
        String content=templateEngine.process("/mail/activation",context);
        mailClient.sendMail(user.getEmail(),"激活账号",content);
        return map;
    }
    public int activation(int userid,String code) {
        User user = userMapper.selectById(userid);
        System.out.println(user);
        if (user.getStatus()==1) {
            return ACTIVATION_REPEAT;
        }else if (user.getActivation_code().equals(code)) {
            int i = userMapper.updateStatus(userid, 1);
            return ACTIVATION_SUCCESS;
        }else {
            return ACTIVATION_FAIL;
        }
    }

}
