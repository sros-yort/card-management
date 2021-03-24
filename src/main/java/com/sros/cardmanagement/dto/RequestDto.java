package com.sros.cardmanagement.dto;

public class RequestDto {
    private String serviceType;
    private Long cardId;
    private Double cardDailyLimit;
    private String cardStatus;
    private Long userId;

    public RequestDto() {
    }

    public RequestDto(String serviceType, Long cardId, Double cardDailyLimit, String cardStatus, Long userId) {
        this.serviceType = serviceType;
        this.cardId = cardId;
        this.cardDailyLimit = cardDailyLimit;
        this.cardStatus = cardStatus;
        this.userId = userId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Double getCardDailyLimit() {
        return cardDailyLimit;
    }

    public void setCardDailyLimit(Double cardDailyLimit) {
        this.cardDailyLimit = cardDailyLimit;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
