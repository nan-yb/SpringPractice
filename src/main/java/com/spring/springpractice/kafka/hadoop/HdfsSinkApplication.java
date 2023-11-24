package com.spring.springpractice.kafka.hadoop;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HdfsSinkApplication {
    private final static Logger logger = LoggerFactory.getLogger(HdfsSinkApplication.class);

    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";
    private final static String TOPIC_NAME = "select-color";
    private final static String GROUP_ID = "color-hdfs_save_consumer_group";
    private final static int CONSUMER_COUNT = 3;
    private final static List<ConsumerWorker> workers = new ArrayList<>();

    public static void main(String[] args) {
        // 안전한 컨슈머의 종료를 위해 셧다운 훅
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());

        Properties configs = new Properties();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG , BOOTSTRAP_SERVERS);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG , GROUP_ID);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class.getName());
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class.getName());

        // 컨슈머 스레드를 스레드풀로 관리하기 위해 newCachedThreadPool 생성
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0 ; i < CONSUMER_COUNT; i++){
            workers.add(new ConsumerWorker(configs , TOPIC_NAME , i));
        }
        workers.forEach(executorService::execute);
    }

    static class ShutdownThread extends Thread{
        public void run() {
            logger.info("shutdown hook");
            workers.forEach(ConsumerWorker::stopAndWakeup);
        }
    }

}
