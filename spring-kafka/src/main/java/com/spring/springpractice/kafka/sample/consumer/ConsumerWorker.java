package com.spring.springpractice.kafka.sample.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.function.Consumer;

public class ConsumerWorker implements  Runnable{

    private final static Logger logger = LoggerFactory.getLogger(Consumer.class);

    private Properties prop;
    private String topic;
    private int threadName;
    private KafkaConsumer<String , String> consumer;

    public ConsumerWorker(Properties prop, String topic, int threadName) {
        this.prop = prop;
        this.topic = topic;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        consumer = new KafkaConsumer<>(prop);
        consumer.subscribe(Arrays.asList(topic));
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String ,String> record : records ){
                logger.info("{}" , record);
            }
        }

    }

}
