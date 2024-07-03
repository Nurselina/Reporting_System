package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    protected <T> ResponseEntity<T> answer(T item, HttpStatus status) {
        return new ResponseEntity<>(item, status);
    }

    protected ResponseEntity<Void> answer(HttpStatus status) {
        return new ResponseEntity<>(status);
    }

}
