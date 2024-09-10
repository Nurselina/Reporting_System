package com.example.demo.core.exception.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AlreadyExistsExceptionType {

    USER_ALREADY_EXISTS(2001, "Kullanıcı zaten mevcut"),

    EMPLOYEE_ALREADY_EXISTS(2002, "Çalışan zaten mevcut"),


    //---------------------------------------------------


    //ALREADY EXISTS Types for Items:

    REPORT_ALREADY_EXISTS(2003, "Rapor zaten mevcut"),

    TASK_ALREADY_EXISTS(2004, "Görev zaten mevcut"),

    PROJECT_ALREADY_EXISTS(2005, "Proje zaten mevcut.");

    //---------------------------------------------------


    private final Integer errorCode;
    private final String message;
}
