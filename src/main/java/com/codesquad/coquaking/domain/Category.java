package com.codesquad.coquaking.domain;

public enum Category {
    TEXT("만담왕"),
    REACTION("이모지왕"),
    BUJIRUN("부지런왕");

    private String name;

    private Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
