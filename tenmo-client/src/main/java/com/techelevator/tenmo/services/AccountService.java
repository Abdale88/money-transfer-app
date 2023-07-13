package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;


public class AccountService {

        private static final String API_BASE_URL = "http://localhost:8080/accounts/";
        private final RestTemplate restTemplate = new RestTemplate();


        private String authToken = null;

        public void setAuthToken(String authToken) {
            this.authToken = authToken;
        }

       public BigDecimal getBalance() {

           ResponseEntity<BigDecimal> response =
                   restTemplate.exchange(API_BASE_URL + "/account/balance", HttpMethod.GET, makeAuthEntity(), BigDecimal.class);

           if (response.getStatusCode() == HttpStatus.OK) {
               return response.getBody();
           } else {
               return null;
           }
       }

        private HttpEntity<Void> makeAuthEntity() {
                HttpHeaders headers = new HttpHeaders();
                headers.setBearerAuth(authToken);
                return new HttpEntity<>(headers);
        }

        private HttpEntity<Account> makeAccountEntity(Account account) {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.setBearerAuth(authToken);
                return new HttpEntity<>(account, headers);
        }

}
