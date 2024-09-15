package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private PollManager pollManager;

    @GetMapping
    public ResponseEntity<Map<String, Vote>> getAllVotes() {
        return ResponseEntity.ok(pollManager.getVotes());
    }

    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
        String pollId = vote.getPollId();
        String optionId = vote.getOptionId();

        // Check if the poll and option exist
        Poll poll = pollManager.getPolls().get(pollId);
        VoteOption option = pollManager.getVoteOptions().get(optionId);

        if (poll != null && option != null) {
            // Create and save the vote
            String voteId = "vote-" + (pollManager.getVotes().size() + 1);
            Vote newVote = new Vote(voteId, pollId, optionId);
            pollManager.addVote(voteId, newVote);

            return ResponseEntity.ok(newVote);
        }

        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVote(@PathVariable String id) {
        Vote vote = pollManager.getVotes().get(id);
        if (vote != null) {
            return ResponseEntity.ok(vote);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vote> updateVote(@PathVariable String id, @RequestBody Vote updatedVote) {
        pollManager.getVotes().put(id, updatedVote);
        return ResponseEntity.ok(updatedVote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVote(@PathVariable String id) {
        pollManager.getVotes().remove(id);
        return ResponseEntity.noContent().build();
    }
}
