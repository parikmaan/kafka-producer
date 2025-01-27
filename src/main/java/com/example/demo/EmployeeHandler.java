package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class EmployeeHandler {
    private final EmployeeProducer producer;

    @Autowired
    public EmployeeHandler(EmployeeProducer producer) {
        this.producer = producer;
    }

    public Mono<ServerResponse> init(ServerRequest request) {
        this.producer.produceMessages();
        return ServerResponse.noContent().build();
    }
}
