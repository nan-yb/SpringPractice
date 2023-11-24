package com.spring.springpractice.kafka.controller;

import com.google.gson.Gson;
import com.spring.springpractice.kafka.UserEventVO;
import org.apache.kafka.common.network.Send;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;


@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class ProduceController {
    private final Logger logger =  LoggerFactory.getLogger(ProduceController.class);

    private final KafkaTemplate<String , String> kafkaTemplate;

    public ProduceController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("api/select")
    public void selectColor(@RequestHeader("user_agent") String userAgentName ,
                            @RequestHeader("color") String colorName ,
                            @RequestHeader("user") String userName){

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
        Date now = new Date();
        Gson gson = new Gson();
        UserEventVO userEventVO = new UserEventVO(sdfDate.format(now) , userAgentName , colorName , userName);
        String jsonColorLog = gson.toJson(userEventVO);

        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("select-color" , jsonColorLog);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                logger.info(result.toString());
            } else {
                logger.info(ex.getMessage() , ex);
            }
        });
    }

}
