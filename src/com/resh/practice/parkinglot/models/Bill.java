package com.resh.practice.parkinglot.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{

    private int amount;
    private ParkingToken billedForToken;
    private Date exitTime;
    private Gate generatedAtGate;
    private Operator generatedByOperator;
    private BillStatus billStatus;
    private List<Payment> payments;
    private FeesCalculatorStrategyType feesCalculatorStrategyType;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ParkingToken getBilledForToken() {
        return billedForToken;
    }

    public void setBilledForToken(ParkingToken billedForToken) {
        this.billedForToken = billedForToken;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Gate getGeneratedAtGate() {
        return generatedAtGate;
    }

    public void setGeneratedAtGate(Gate generatedAtGate) {
        this.generatedAtGate = generatedAtGate;
    }

    public Operator getGeneratedByOperator() {
        return generatedByOperator;
    }

    public void setGeneratedByOperator(Operator generatedByOperator) {
        this.generatedByOperator = generatedByOperator;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public FeesCalculatorStrategyType getFeesCalculatorStrategyType() {
        return feesCalculatorStrategyType;
    }

    public void setFeesCalculatorStrategyType(FeesCalculatorStrategyType feesCalculatorStrategyType) {
        this.feesCalculatorStrategyType = feesCalculatorStrategyType;
    }
}
