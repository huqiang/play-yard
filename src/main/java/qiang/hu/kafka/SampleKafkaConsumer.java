package qiang.hu.kafka;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class SampleKafkaConsumer {

    /*
    RECEIVED_MESSAGE_KEY is deprecated
    https://github.com/spring-projects/spring-kafka/commit/df4e0aad1405bfa76e1f018d38a7cf5557de551f
     */
    @KafkaListener(
            topics = {"sample-topic-01"},
            groupId = "sample-group-01")
    public void consumeMessage(@Header(KafkaHeaders.RECEIVED_KEY) String messageKey,
                               @Payload String payload,
                               Acknowledgment acknowledgment) {
        log.debug("Received message: {}", payload);
        if (isDuplicateMessage(messageKey)) {
            log.debug("Duplicate message: {}", payload);
            acknowledgment.acknowledge();
            return;
        }
        try {
            // do something

        } catch (Exception e) {
            log.error("Error occurred while processing message: {}", payload, e);
            acknowledgment.acknowledge();
        }
        acknowledgment.acknowledge();
    }

    private boolean isDuplicateMessage(String messageKey) {
        // check local DB;
        return false;
    }

    @PostConstruct
    public void init() {
        log.info("Kafka consumer created");
    }
}
