package com.techelevator.tenmo.dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
    @Component
    public class JdbcAccountDao implements AccountDao {

        //Spring injects instance
        private final JdbcTemplate jdbcTemplate;

        public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        //queries to get balance
        @Override
        public BigDecimal getAccountBalance(String username) {
            String sql = "SELECT balance FROM account " +
                    "JOIN tenmo_user ON tenmo_user.user_id = account.user_id " +
                    "WHERE tenmo_user.username = ?";
            return jdbcTemplate.queryForObject(sql, BigDecimal.class, username);
        }

        //query to update balance
        @Override
        public boolean updateAccountBalance(String username, BigDecimal newBalance) {
            String sql = "UPDATE account " +
                    "SET balance = ? " +
                    "FROM tenmo_user " +
                    "WHERE tenmo_user.user_id = account.user_id " +
                    "AND tenmo_user.username = ?";
            int rowsAffected = jdbcTemplate.update(sql, newBalance, username);
            return rowsAffected > 0;
        }
    }

