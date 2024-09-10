package com.example.demo.core.exception.type;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotFoundExceptionType {

    GENERIC_EXCEPTION(1, "Bilinmeyen hata"),

    //DATA NOT FOUND Types for Users:
    USER_DATA_NOT_FOUND(1001, "Kullanıcı bulunamadı"),
    USER_LIST_NOT_FOUND(1002, "Kullanıcı listesi mevcut değil."),

    EMPLOYEE_DATA_NOT_FOUND(1003, "Çalışan bulunamadı"),
    EMPLOYEE_LIST_NOT_FOUND(1004, "Çalışan listesi mevcut değil."),

    //----------------------------------------------------------------------------------


    //DATA NOT FOUND Types for Items:
    REPORT_DATA_NOT_FOUND(1005, "Rapor bulunamadı"),
    REPORT_LIST_NOT_FOUND(1006, "Rapor listesi mevcut değil."),

    TASK_DATA_NOT_FOUND(1007, "Görev bulunamadı"),
    TASK_LIST_NOT_FOUND(1008, "Görev listesi mevcut değil."),

    PROJECT_DATA_NOT_FOUND(1009, "Proje bulunamadı"),
    PROJECT_LIST_NOT_FOUND(1010, "Proje listesi mevcut değil."),

    ROLE_DATA_NOT_FOUND(1011, "Rol bulunamadı.");
    //----------------------------------------------------------------------------------

    private final Integer errorCode;
    private final String message;
}
