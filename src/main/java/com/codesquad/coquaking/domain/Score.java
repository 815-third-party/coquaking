package com.codesquad.coquaking.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int textScore;
    private int emojiScore;
    private int bujinrunScore;

    @CreationTimestamp
    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Score() {
    }

    public Score(User user, int textScore, int emojiScore, int bujinrunScore) {
        this.user = user;
        this.textScore = textScore;
        this.emojiScore = emojiScore;
        this.bujinrunScore = bujinrunScore;
    }

    public int getTextScore() {
        return textScore;
    }

    public int getEmojiScore() {
        return emojiScore;
    }

    public int getBujinrunScore() {
        return bujinrunScore;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }
}
