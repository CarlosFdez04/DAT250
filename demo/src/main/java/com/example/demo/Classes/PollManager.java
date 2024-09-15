package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {
    private Map<String, Poll> polls = new HashMap<>();
    private Map<String, User> users = new HashMap<>();
    private Map<String, Vote> votes = new HashMap<>();
    private Map<String, VoteOption> voteOptions = new HashMap<>();

    public Map<String, Poll> getPolls() {
        return polls;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Vote> getVotes() {
        return votes;
    }

    public Map<String, VoteOption> getVoteOptions() {
        return voteOptions;
    }

    public void addPoll(String id, Poll poll) {
        polls.put(id, poll);
    }

    public void addUser(String id, User user) {
        users.put(id, user);
    }

    public void addVote(String id, Vote vote) {
        votes.put(id, vote);
    }

    public void addVoteOption(String id, VoteOption voteOption) {
        voteOptions.put(id, voteOption);
    }
}