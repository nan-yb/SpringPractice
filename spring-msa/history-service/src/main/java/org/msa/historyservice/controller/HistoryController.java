package org.msa.historyservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.msa.historyservice.dto.HistoryDTO;
import org.msa.historyservice.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(value="v1/history")
@RestController
public class HistoryController {
    @RequestMapping(value="/save" , method= RequestMethod.POST)
    public ResponseEntity<ResponseDTO> history(HttpServletRequest req , @RequestBody HistoryDTO historyDTO) throws Exception{
        ResponseDTO.ResponseDTOBuilder responseDTOBuilder = ResponseDTO.builder();

        log.info("history = {}" , historyDTO.toString());

        responseDTOBuilder.code("200").message("success");
        return ResponseEntity.ok(responseDTOBuilder.build());
    }

}
