package com.example.item.controller;


import com.example.item.dto.ItemDTO;
import com.example.item.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/item")
@Slf4j
public class ItemController {
    @RequestMapping(value="/add" , method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> add(@RequestBody ItemDTO itemDTO){
        ResponseDTO.ResponseDTOBuilder  responseBuilder = ResponseDTO.builder();

        log.debug("request add item id  = {}" , itemDTO.getId());

        responseBuilder.code("200").message("success");
        return ResponseEntity.ok(responseBuilder.build());
    }

}
