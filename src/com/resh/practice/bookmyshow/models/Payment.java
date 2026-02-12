package com.resh.practice.bookmyshow.models;

import com.resh.practice.parkinglot.models.PaymentMode;
import com.resh.practice.parkinglot.models.PaymentStatus;

public class Payment extends BaseModel{

    private int amount;
    private PaymentProvider providerType;
    private PaymentStatus status;
    private int transactionId;
    private PaymentMode mode;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentProvider getProviderType() {
        return providerType;
    }

    public void setProviderType(PaymentProvider providerType) {
        this.providerType = providerType;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }
}
