package com.micros.fraud.model;

public class FraudCheckResponse {

    Boolean isFraudster;

    public FraudCheckResponse() {};
    public FraudCheckResponse(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }

    public Boolean getFraudster() {
        return isFraudster;
    }

    public void setFraudster(Boolean fraudster) {
        isFraudster = fraudster;
    }
}
