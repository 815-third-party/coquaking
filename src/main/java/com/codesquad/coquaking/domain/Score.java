package com.codesquad.coquaking.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Score {
    private int textScore;
    private int emojiScore;
    private int bujinrunScore;


    public Score() {
    }

    public Score(int textScore, int emojiScore, int bujinrunScore) {
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
}
