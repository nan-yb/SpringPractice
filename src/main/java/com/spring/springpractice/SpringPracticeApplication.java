package com.spring.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

@SpringBootApplication
public class SpringPracticeApplication  implements CommandLineRunner {

    private static String TOPIC_NAME = "test";

    @Autowired
    private KafkaTemplate<String , String> template;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringPracticeApplication.class);
        application.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        ListenableFuture<SendResult<String,String>> future = template.send(TOPIC_NAME , "test");
        template.send(TOPIC_NAME , "test");

        future.addCallback(new KafkaSendCallback<String, String>(){

            @Override
            public void onSuccess(SendResult<String, String> result) {

            }

            @Override
            public void onFailure(KafkaProducerException ex) {

            }


        });

        System.exit(0);

//        for (int i = 0; i< 10; i++){
//            template.send(TOPIC_NAME , "test" + i);
//        }
//        System.exit(0);
    }
}


