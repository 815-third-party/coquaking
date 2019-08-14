package com.codesquad.coquaking.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slackId;

    private String name;

    private String thumbnail;

    @CreatedDate
    private LocalDateTime createTime;


    @Embedded
    private Score score;

    private User() {
    }

    public User(String slackId, String name, String thumbnail, Score score) {
        this.slackId = slackId;
        this.name = name;
        this.thumbnail = thumbnail;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public String getSlackId() {
        return slackId;
    }

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Score getScore() {
        return score;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", slackId='" + slackId + '\'' +
                ", name='" + name + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", createTime=" + createTime +
                ", score=" + score +
                '}';
    }
}
