package com.codesquad.coquaking.dto;

public class DemoDto {
    private String type;
    private String token;
    private String challenge;

    public DemoDto() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    @Override
    public String toString() {
        return "DemoDto{" +
                "type='" + type + '\'' +
                ", token='" + token + '\'' +
                ", challenge='" + challenge + '\'' +
                '}';
    }
}
