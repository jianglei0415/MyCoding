package com.springboot.chapter14.enumeration;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: jianglei
 * @date: 2020/2/2 14:24
 */
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(0, "女");

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SexEnum getSexEnum(int code) {
        SexEnum[] enums = SexEnum.values();
        for (SexEnum item : enums) {
            if (item.getCode() == code) {
                return item;
            }
        }
        return null;
    }
}
