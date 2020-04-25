package com.example.nowcoder.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author admin
 * @ClassName DiscussPost.java
 * @Description TODO
 * @createTime 2020年04月24日 19:00:00
 */
@Data
public class DiscussPost {

    private Integer id;
    private Integer user_id;
    private String title;
    private String content;
    private Integer type;
    private Integer status;
    private Date create_time;
    private Integer comment_account;
    private Double score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getComment_account() {
        return comment_account;
    }

    public void setComment_account(Integer comment_account) {
        this.comment_account = comment_account;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
