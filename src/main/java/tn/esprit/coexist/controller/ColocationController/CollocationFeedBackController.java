package tn.esprit.coexist.controller.ColocationController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.service.ColocationService.CollocationFeedback.CollocationFeedbackService;
import tn.esprit.coexist.service.ColocationService.CollocationFeedback.CollocationFeedbackServiceImp;

@RestController
@RequestMapping("AnnonceFeedBack")
@AllArgsConstructor
public class CollocationFeedBackController {
    @Autowired
    private CollocationFeedbackService collocationService;
    private CollocationFeedbackServiceImp collocationServiceimp;

    @PostMapping("/collocations/{collocationId}/feedback")
    public ResponseEntity<String> addFeedbackToCollocation(
            @PathVariable Integer collocationId,
            @RequestBody String feedbackNote) {
        collocationService.addFeedbackToCollocation(collocationId, feedbackNote);
        return ResponseEntity.ok("Feedback added successfully.");
    }
    @DeleteMapping("/deleteFeedbackCollocation/{FeedbackCollocationId}")
    public void delete(@PathVariable("FeedbackCollocationId") Integer FeedbackCollocationId) {
        collocationServiceimp.delete(FeedbackCollocationId);
    }
}
