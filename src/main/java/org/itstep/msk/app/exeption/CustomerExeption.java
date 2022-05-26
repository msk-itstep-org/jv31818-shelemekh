package org.itstep.msk.app.exeption;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomerExeption extends RuntimeException {

    private String message;
    private HttpStatus status;

    public CustomerExeption(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public static CustomerExeption creteException(String msg) {
        return new CustomerExeption(msg, HttpStatus.NOT_FOUND);
    }
}