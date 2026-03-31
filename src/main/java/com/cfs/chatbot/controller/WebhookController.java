package com.cfs.chatbot.controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WebhookController {

    @PostMapping("/webhook")
    public Map<String, String> receiveMessage(@RequestBody Map<String, String> request) {

        String message = request.get("message");
        System.out.println("Received message: " + message); // Logging

        String reply;

        if (message.equalsIgnoreCase("Hi")) {
            reply = "Hello";
        } else if (message.equalsIgnoreCase("Bye")) {
            reply = "Goodbye";
        } else {
            reply = "I don't understand";
        }

        Map<String, String> response = new HashMap<>();
        response.put("reply", reply);

        return response;
    }
}