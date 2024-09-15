package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollManager pollManager;

    @GetMapping
    public ResponseEntity<Map<String, Poll>> getAllPolls() {
        return ResponseEntity.ok(pollManager.getPolls());
    }

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        String id = generatePollId();
        poll.setId(id); // Ensure poll has an ID

        // Save each option in the poll
        if (poll.getOptions() != null) {
            for (VoteOption option : poll.getOptions()) {
                String optionId = "option-" + (pollManager.getVoteOptions().size() + 1);
                option.setId(optionId);
                pollManager.addVoteOption(optionId, option); // Save each option
            }
        }

        pollManager.addPoll(id, poll);
        return ResponseEntity.ok(poll);
    }

    private String generatePollId() {
        return "poll-" + (pollManager.getPolls().size() + 1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable String id) {
        Poll poll = pollManager.getPolls().get(id);
        if (poll != null) {
            return ResponseEntity.ok(poll);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Poll> updatePoll(@PathVariable String id, @RequestBody Poll updatedPoll) {
        pollManager.getPolls().put(id, updatedPoll);
        return ResponseEntity.ok(updatedPoll);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoll(@PathVariable String id) {
        pollManager.getPolls().remove(id);
        return ResponseEntity.noContent().build();
    }
}
