package com.st;

import java.util.concurrent.CompletionStage;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Broadcaster {

    // @Channel("broadcaster")
    // Emitter<String> emitter;

    @Incoming("data")
    public CompletionStage<Void> consume(Message<String> message) {
        System.out.println("Received: " + message.getPayload());
        // emitter.send(message.getPayload());
        return message.ack();
    }


}
