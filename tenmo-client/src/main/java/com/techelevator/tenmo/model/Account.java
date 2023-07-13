package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Account {

    private String accountId;
    private String userId;
    private BigDecimal balance;

    public String getAccountId(){ return accountId;}

    public void setAccountId(){this.accountId = accountId;}
    public String getUserId(){ return userId;}
    public void setUserId(String userId){
        this.userId = userId;
    }
    public BigDecimal getBalance(String username){
        return balance;
    }

    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }
}
