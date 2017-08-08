package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by Arif on 08-Aug-17.
 */
@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Received <" + email + ">");
    }

}