package com.sros.cardmanagement.service;

import com.sros.cardmanagement.constant.CardStatus;
import com.sros.cardmanagement.dto.RequestDto;
import com.sros.cardmanagement.dto.ResponseDto;
import com.sros.cardmanagement.entity.Card;
import com.sros.cardmanagement.exception.RequestException;
import com.sros.cardmanagement.repository.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CardService.class);

    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    public ResponseDto processRequest(RequestDto requestDto, ResponseDto responseDto) {
        try {
            String serviceType = requestDto.getServiceType();
            if (serviceType == null) {
                throw new RequestException("Request param error!");
            }

            switch (serviceType) {
                case "get-user-cards":
                    this.findByUserId(requestDto, responseDto);
                    break;
                case "get-card-detail":
                    this.detail(requestDto, responseDto);
                    break;
                case "update-card-status":
                    this.updateStatus(requestDto, responseDto);
                    break;
                case "change-card-daily-limit":
                    this.changeDailyLimit(requestDto, responseDto);
                    break;
                default:
                    responseDto.setMessage("Unknown request service type!");
            }

        } catch (RequestException e) {
            LOGGER.error("Request error", e);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }

    private void findByUserId(RequestDto requestDto, ResponseDto responseDto) throws RequestException {
        Long userId = requestDto.getUserId();
        if (userId == null) {
            throw new RequestException("Request param error, userId require!");
        }
        Iterable<Card> cards = this.cardRepository.findByUserId(userId);
        responseDto.setData(cards);
        responseDto.setMessage("Success");
    }

    private void detail(RequestDto requestDto, ResponseDto responseDto) throws RequestException {
        Long cardId = requestDto.getCardId();
        if (cardId == null) {
            throw new RequestException("Request param error, cardId require!");
        }

        Card card = this.getCardById(cardId);
        responseDto.setData(card);
        responseDto.setMessage("Success");
    }

    private void updateStatus(RequestDto requestDto, ResponseDto responseDto) throws RequestException {
        Long cardId = requestDto.getCardId();
        String cardStatus = requestDto.getCardStatus();
        if (cardId == null || "".equals(cardStatus)) {
            throw new RequestException("Request param error, cardId and cardStatus are require!");
        }

        if (!CardStatus.contains(cardStatus.toUpperCase())) {
            throw new RequestException("CardStatus value invalid!");
        }

        Card card = this.getCardById(cardId);
        card.setStatus(cardStatus);
        card = this.cardRepository.save(card);

        responseDto.setData(card);
        responseDto.setMessage("Success");
    }

    private void changeDailyLimit(RequestDto requestDto, ResponseDto responseDto) throws RequestException {
        Long cardId = requestDto.getCardId();
        Double dailyLimit = requestDto.getCardDailyLimit();
        if (cardId == null || dailyLimit == null || dailyLimit < 0) {
            throw new RequestException("Request param error, cardId and cardDailyLimit are require!");
        }

        Card card = this.getCardById(cardId);
        card.setDailyLimit(dailyLimit);
        card = this.cardRepository.save(card);

        responseDto.setData(card);
        responseDto.setMessage("Success");
    }

    private Card getCardById(long cardId) {
        Optional<Card> cardOpt = this.cardRepository.findById(cardId);
        if (!cardOpt.isPresent()) {
            throw new RequestException("Card not found!");
        }
        return cardOpt.get();
    }
}
