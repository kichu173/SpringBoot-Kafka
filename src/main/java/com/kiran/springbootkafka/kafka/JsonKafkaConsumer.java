package com.kiran.springbootkafka.kafka;

import com.kiran.springbootkafka.model.User;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    // Spring Kafka provided JsonDeserializer will convert User JSON obj into Java User Obj
    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    private void consumer(User user) {
        LOG.info(String.format("Json message received -> %s", user.toString()));
    }
}
