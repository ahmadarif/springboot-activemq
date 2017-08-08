package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Arif on 08-Aug-17.
 */
@RestController
public class Controller {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/queue")
    public ResponseEntity<Map> sendQueue() {
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
        return ResponseEntity.ok(Collections.singletonMap("message", "Sending an email message."));
    }

}
