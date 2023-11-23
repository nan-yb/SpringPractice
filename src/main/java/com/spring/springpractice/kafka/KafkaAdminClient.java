package com.spring.springpractice.kafka;

import com.spring.springpractice.kafka.consumer.SimpleConsumer;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeConfigsResult;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.config.ConfigResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaAdminClient {

    private final static Logger logger = LoggerFactory.getLogger(SimpleConsumer.class);
    private final static String TOPIC_NAME = "test";
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";
    private final static String GROUP_ID = "test-group";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties configs = new Properties();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
//        configs.put(ConsumerConfig.GROUP_ID_CONFIG , GROUP_ID);
//        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class.getName());
//        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class.getName());

        AdminClient admin = AdminClient.create(configs);

        logger.info("== Get broker information");
        for (Node node : admin.describeCluster().nodes().get()){
            logger.info("node : {}" , node);
            ConfigResource cr = new ConfigResource(ConfigResource.Type.BROKER , node.idString());
            DescribeConfigsResult describeConfigsResult = admin.describeConfigs(Collections.singleton(cr));
            describeConfigsResult.all().get().forEach((broker , config)->{
                config.entries().forEach(configEntry -> logger.info(configEntry.name() + "=" + configEntry.value()));
            });
        }

    }
}
