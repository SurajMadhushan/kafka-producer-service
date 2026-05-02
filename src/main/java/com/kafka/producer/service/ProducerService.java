package com.kafka.producer.service;

import com.kafka.producer.models.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String,ResponseData> kafkaTemplate;

    public void sendMessage(ResponseData message){
        System.out.println("Message sent to Kafka: " + message);
        kafkaTemplate.send(
                "test",
                message
        );
    }

    public ResponseData sendData(){
        ResponseData responseData = new ResponseData(
                "btc", 30000.0, System.currentTimeMillis()
        );

        sendMessage(responseData);
        return responseData;
    }

    @Scheduled(fixedRate = 1500)
    public void sendRealTimeDataBitcoin() {
        System.out.println("Sending real-time data...");

        double price = 30000.0 + Math.random() * 1000;
        ResponseData responseData = new ResponseData("btc", price, System.currentTimeMillis());
        sendMessage(responseData);

    }

    @Scheduled(fixedRate = 1500)
    public void sendRealTimeDataBNB() {
        System.out.println("Sending real-time data...");

        double price = 700.0 + Math.random() * 100;
        ResponseData responseData = new ResponseData("eth", price, System.currentTimeMillis());
        sendMessage(responseData);

    }

    @Scheduled(fixedRate = 1500)
    public void sendRealTimeDataEthereum() {
        System.out.println("Sending real-time data...");

        double price = 2500.0 + Math.random() * 500;
        ResponseData responseData = new ResponseData("sol", price, System.currentTimeMillis());
        sendMessage(responseData);

    }


}
