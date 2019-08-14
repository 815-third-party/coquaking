package com.codesquad.coquaking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slackId;

    private String name;

    private String thumbnail;

    private User() {
    }

    public User(String slackId, String name, String thumbnail) {
        this.slackId = slackId;
        this.name = name;
        this.thumbnail = thumbnail;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
