package org.binar.kafkaservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.binar.kafkaservice.kafka.KafkaConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {

    private KafkaTemplate<String, String> template;
    private KafkaConsumer kafkaConsumer;

    public KafkaController(KafkaTemplate<String, String> template, KafkaConsumer kafkaConsumer) {
        this.template = template;
        this.kafkaConsumer = kafkaConsumer;
    }

    @GetMapping("/produce")
    public void produce(@RequestParam String message) {
        template.send("myTopic", message);
    }

    @GetMapping("/messages")
    public List<String> getMessages() {
        return kafkaConsumer.getMessages();
    }

}
