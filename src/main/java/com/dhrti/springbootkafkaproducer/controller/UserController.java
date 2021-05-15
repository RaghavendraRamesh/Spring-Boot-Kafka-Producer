package com.dhrti.springbootkafkaproducer.controller;

import com.dhrti.springbootkafkaproducer.dto.CasesInfo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/corona")
public class UserController {

    private KafkaTemplate<Integer, CasesInfo> kafkaTemplate;
    private static final String TOPIC = "kafka_producer";

    public UserController(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/postinfo")
    public String postinfo(@RequestBody CasesInfo casesInfo){
        kafkaTemplate.send(TOPIC, casesInfo);
        return "Published Successfully!!";
    }
}
