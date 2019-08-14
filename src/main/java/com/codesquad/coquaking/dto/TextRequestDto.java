package com.codesquad.coquaking.dto;

public class TextRequestDto {
    private String slackId;
    private String text;

    public TextRequestDto() {
    }

    public TextRequestDto(String slackId, String text) {
        this.slackId = slackId;
        this.text = text;
    }

    public String getSlackId() {
        return slackId;
    }

    public void setSlackId(String slackId) {
        this.slackId = slackId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
