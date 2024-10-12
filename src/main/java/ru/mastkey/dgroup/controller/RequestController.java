package ru.mastkey.dgroup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mastkey.dgroup.bot.NotifyBot;
import ru.mastkey.dgroup.model.request.FeedbackRequest;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class RequestController {

    private final NotifyBot notifyBot;

    @PostMapping
    public ResponseEntity<?> postFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        notifyBot.sendMessageToAdmins(feedbackRequest.toString());
        return ResponseEntity.ok().build();
    }
}
