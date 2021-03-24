package com.sros.cardmanagement.controller;

import com.sros.cardmanagement.dto.RequestDto;
import com.sros.cardmanagement.dto.ResponseDto;
import com.sros.cardmanagement.service.CardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cards")
public class CardRestController {

    private CardService cardService;

    public CardRestController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseDto cardRequestResponse(@RequestBody RequestDto requestDto) {
        return this.cardService.processRequest(requestDto, new ResponseDto());
    }

}
