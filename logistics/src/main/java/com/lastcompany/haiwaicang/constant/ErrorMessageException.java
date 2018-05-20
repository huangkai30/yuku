package com.lastcompany.haiwaicang.constant;

import org.springframework.dao.DataAccessException;


public class ErrorMessageException extends DataAccessException {
    public ErrorMessageException(String s) {
        super(s);
    }
}
