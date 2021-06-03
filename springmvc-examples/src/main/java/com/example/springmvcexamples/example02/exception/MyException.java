package com.example.springmvcexamples.example02.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyException extends RuntimeException {
    private int code;

    public MyException(int code, String message) {
        super(message);
        this.code = code;
    }
}
