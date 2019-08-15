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
    @OneToOne
    @JoinColumn(name = "third_user")
    private User third;

    public Archive() {
    }

    public Archive(Category category, User first, User second, User third) {
        this.category = category;
        this.first = first;
        this.second = second;
        this.third = third;
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

    public User getThird() {
        return third;
    }
}
