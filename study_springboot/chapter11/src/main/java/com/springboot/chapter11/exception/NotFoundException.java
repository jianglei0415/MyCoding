package com.springboot.chapter11.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: jianglei
 * @date: 2020/1/31 14:54
 */
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private Long code;
    @Getter
    @Setter
    private String customMsg;

    public NotFoundException() {
    }

    public NotFoundException(Long code, String customMsg) {
        this.code = code;
        this.customMsg = customMsg;
    }
}
