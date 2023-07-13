package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;

import java.math.BigDecimal;
import java.util.List;


public interface AccountDao {
        BigDecimal getAccountBalance(String username);

        boolean updateAccountBalance(String username, BigDecimal newBalance);

    }

