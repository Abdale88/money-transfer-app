package com.techelevator.tenmo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class Account {

    @NotBlank(message = "This field is required")
    private String accountId;
    @NotBlank(message = "This field is required")
    private String userId;
    @Min(value = 1000, message = "Balance should not be less than $1,000")
    private BigDecimal balance; //default balance is 1,000

    //default balance for a new account is $1,000
    public Account(String accountId, String userId) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = BigDecimal.valueOf(1000.00);
        }

        //account constructor for balance not $1,000
    public Account(String accountId, String userId, BigDecimal balance){
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
        }

    public String getAccountId() {return accountId;}

    public void setAccountId(){this.accountId = accountId;}

    public String getUserId() {return userId;}

    public void setUserId(){this.userId = userId;}

    public BigDecimal getBalance(){return balance;}
    public void setBalance(){this.balance = balance;}


        @Override
        public String toString() {
            return "Account{" +
                    "accountId=" + accountId +
                    ", userId=" + userId +
                    ", balance=" + balance +
                    '}';
        }
    }


