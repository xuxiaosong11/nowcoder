package com.example.nowcoder.dao;


import com.example.nowcoder.entiy.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年04月24日 17:07:00
 */
@Repository
@Mapper
public interface UserMapper {

    User selectById(int id);
    User selectByName(String username);
    User selectByEmail(String email);
    int insertUser(User user);
    int updateStatus(int id,int status);
    int updateHeader(int id,String headerUrl);
    int updatePassword(int id,String password);


}
