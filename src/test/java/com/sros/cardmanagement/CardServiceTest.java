package com.sros.cardmanagement;

import com.sros.cardmanagement.dto.RequestDto;
import com.sros.cardmanagement.dto.ResponseDto;
import com.sros.cardmanagement.service.CardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceTest {

    @Autowired
    private CardService cardService;

    @Test
    public void whenValidRequestParam_thenResponseSuccess(){
        RequestDto requestDto = new RequestDto();
        requestDto.setServiceType("get-user-cards");
        requestDto.setUserId(3L);
        ResponseDto responseDto = this.cardService.processRequest(requestDto, new ResponseDto());
        assertThat(responseDto.getMessage()).isEqualTo("Success");
    }
}
