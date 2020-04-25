package com.example.nowcoder.controller;

import com.example.nowcoder.dao.DiscussPostMapper;
import com.example.nowcoder.entiy.DiscussPost;
import com.example.nowcoder.entiy.Page;
import com.example.nowcoder.entiy.User;
import com.example.nowcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @ClassName DiscussPostController.java
 * @Description TODO
 * @createTime 2020年04月24日 20:19:00
 */
@Controller
public class DiscussPostController {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private UserService userService;


    @GetMapping("/index")
    public String test(Model model,Page page) {
        page.setRows(discussPostMapper.selectDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> post=new ArrayList<>();
        if (discussPosts != null) {
            for (DiscussPost discussPost: discussPosts) {
                Map<String,Object> map=new HashMap<>();
                map.put("post",discussPost);
              User user=  userService.selectById(discussPost.getUser_id());
              map.put("user",user);
              post.add(map);
            }
        }
        model.addAttribute("post",post);
        return "/index";
    }
}
