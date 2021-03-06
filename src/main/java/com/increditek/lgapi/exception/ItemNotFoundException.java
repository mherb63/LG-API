package com.increditek.lgapi.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String msg) {
        super(msg);
        log.error(msg);
    }
}
