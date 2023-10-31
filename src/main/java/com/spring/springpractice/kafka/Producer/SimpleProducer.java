package com.spring.springpractice.kafka.Producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class SimpleProducer {
    private final static Logger logger = LoggerFactory.getLogger(SimpleProducer.class);
    private final static String TOPIC_NAME = "test";
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG , BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG , StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG , StringSerializer.class.getName());
        configs.put(ProducerConfig.PARTITIONER_CLASS_CONFIG , CustomPartitioner.class);

        KafkaProducer<String , String> producer = new KafkaProducer<>(configs);

        String messageKey = "sdsd";
        String messageValue = "testMessage";
//        ProducerRecord<String , String> record = new ProducerRecord<>(TOPIC_NAME , messageValue);

        ProducerRecord<String , String> record = new ProducerRecord<>("test" , "Pangyo" , "23");

//        int partitionNo = 0;
//        ProducerRecord<String , String> record = new ProducerRecord<>(TOPIC_NAME  , partitionNo, messageKey , messageValue);
        producer.send(record , new ProducerCallback());
        logger.info("{}" , record);
        producer.flush();
        producer.close();

    }

    // bootstrap.servers : 프로듀서가 데이터를 전송할 대상 카프카 클로스터에 속한 브로커의 호스트 이름:포트를 1개 이상 작성
    // key.serializer : 레코드의 메시지 키를 직렬화하는 클래스를 지정한다.
    // value.serializer : 레코드의 메시지 값을 직렬화하는 클래스르 지정한다.


}
