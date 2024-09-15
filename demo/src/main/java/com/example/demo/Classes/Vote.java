package com.example.demo;

public class Vote {
    private String id;
    private String pollId;
    private String optionId;

    public Vote() {}

    public Vote(String id, String pollId, String optionId) {
        this.id = id;
        this.pollId = pollId;
        this.optionId = optionId;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPollId() { return pollId; }
    public void setPollId(String pollId) { this.pollId = pollId; }
    public String getOptionId() { return optionId; }
    public void setOptionId(String optionId) { this.optionId = optionId; }
}
