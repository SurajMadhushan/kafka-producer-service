package com.kafka.producer.controller;

import com.kafka.producer.models.ResponseData;
import com.kafka.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @GetMapping("/send")
    public ResponseEntity<ResponseData> sendData() {
        return new ResponseEntity<>(producerService.sendData(), HttpStatus.OK);
    }

}
