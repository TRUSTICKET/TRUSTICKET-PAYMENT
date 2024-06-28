package com.trusticket.trusticketpayment.common.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trusticket.trusticketpayment.dto.PaymentData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendPaymentSuccess(String topic, PaymentData data){
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(data);
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }


        // KafkaTemplate을 사용하여 지정된 토픽에 JSON 문자열을 전송
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, jsonInString);

        log.info("Kafka Producer send data " + data);

    }


}
