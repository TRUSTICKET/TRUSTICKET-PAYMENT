package com.trusticket.trusticketpayment.config.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    private final String url;
    public KafkaConsumerConfig(
            @Value("${spring.kafka.bootstrap-servers}") String url
    ) {
        this.url = url;
    }

    // Kafka 컨슈머를 생성하기 위한 ConsumerFactory 빈을 정의
    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        Map<String, Object> properties = new HashMap<>();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, url);

        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "trust-core");

        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        return new DefaultKafkaConsumerFactory<>(properties);
    }

    // 메시지를 수신하는 KafkaListenerContainerFactory 빈 정의
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
        // ConcurrentKafkaListenerContainerFactory를 생성
        ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory =
                new ConcurrentKafkaListenerContainerFactory<>();

        // 위에서 정의한 ConsumerFactory를 설정하여 KafkaListenerContainerFactory에 주입.
        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory());

        return kafkaListenerContainerFactory;
    }
}
