package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/voteOptions")
public class VoteOptionController {

    @Autowired
    private PollManager pollManager;

    @GetMapping
    public ResponseEntity<Map<String, VoteOption>> getAllVoteOptions() {
        return ResponseEntity.ok(pollManager.getVoteOptions());
    }

    @PostMapping
    public ResponseEntity<VoteOption> createVoteOption(@RequestBody VoteOption voteOption) {
        String id = "option-" + (pollManager.getVoteOptions().size() + 1);
        voteOption.setId(id);
        pollManager.addVoteOption(id, voteOption);
        return ResponseEntity.ok(voteOption);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoteOption> getVoteOption(@PathVariable String id) {
        VoteOption voteOption = pollManager.getVoteOptions().get(id);
        if (voteOption != null) {
            return ResponseEntity.ok(voteOption);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VoteOption> updateVoteOption(@PathVariable String id, @RequestBody VoteOption updatedVoteOption) {
        updatedVoteOption.setId(id);
        pollManager.addVoteOption(id, updatedVoteOption);
        return ResponseEntity.ok(updatedVoteOption);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoteOption(@PathVariable String id) {
        pollManager.getVoteOptions().remove(id);
        return ResponseEntity.noContent().build();
    }
}