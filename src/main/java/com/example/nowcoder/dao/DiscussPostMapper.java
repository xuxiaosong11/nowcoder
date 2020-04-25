package com.example.nowcoder.dao;

import com.example.nowcoder.entiy.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @ClassName DiscussPostMapper.java
 * @Description TODO
 * @createTime 2020年04月24日 19:49:00
 */
@Mapper
@Repository
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(@Param("user_id") int user_id,@Param("offset") int offset,@Param("limit") int limit);

    int selectDiscussPostRows(@Param("user_id") int user_id);
}
