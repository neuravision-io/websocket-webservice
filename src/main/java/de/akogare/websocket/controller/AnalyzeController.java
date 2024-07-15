package de.akogare.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class AnalyzeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnalyzeController.class);
    private final SimpMessagingTemplate messagingTemplate;

    public AnalyzeController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/main")
    @SendTo("/receiver")
    public void startAnalyzeProcess(String msg) {
        LOGGER.info("Received message: {}", msg);
        messagingTemplate.convertAndSend("/topic/main", msg);
    }
}