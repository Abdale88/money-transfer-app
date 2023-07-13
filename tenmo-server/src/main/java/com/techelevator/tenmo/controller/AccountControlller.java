package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.LoginDTO;
import com.techelevator.tenmo.model.LoginResponseDto;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.http.HttpEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountControlller {
        private AccountDao accountDao;

        public AccountControlller(AccountDao accountDao) {
            this.accountDao = accountDao;
        }

        //gets username of the user
        private String getAuthenticatedUsername() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return authentication.getName();
        }

        @GetMapping("/balance")
        public BigDecimal getAccountBalance() {
            String username = getAuthenticatedUsername();
            return accountDao.getAccountBalance(username);
        }
    }




