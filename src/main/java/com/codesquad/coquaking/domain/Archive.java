package com.codesquad.coquaking.domain;

import javax.persistence.*;

@Entity
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @OneToOne
    @JoinColumn(name = "first_user")
    private User first;
    @OneToOne
    @JoinColumn(name = "second_user")
    private User second;

    public Archive() {
    }

    public Archive(Category category, User first, User second) {
        this.category = category;
        this.first = first;
        this.second = second;
    }

    public Category getCategory() {
        return category;
    }

    public User getFirst() {
        return first;
    }

    public User getSecond() {
        return second;
    }
}
