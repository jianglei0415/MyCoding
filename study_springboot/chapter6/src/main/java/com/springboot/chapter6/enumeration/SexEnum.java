package com.springboot.chapter6.enumeration;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:33
 */
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SexEnum getEnumById(int id) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getId() == id) {
                return sex;
            }
        }
        return null;
    }
}
