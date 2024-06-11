package com.libary.my.constant;

import lombok.Getter;

@Getter
public enum RecordStatusEnum {

    RETURNED(0, "Returned"),
    IN_BORROWING(1, "In Borrowing");


    private final Integer status;
    private final String description;

    RecordStatusEnum(Integer status, String description) {
        this.status = status;
        this.description = description;
    }

}
