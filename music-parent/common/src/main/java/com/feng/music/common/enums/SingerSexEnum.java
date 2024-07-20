package com.feng.music.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 *
 * @author linqf
 * @description
 * @date 2024-07-18
 */
@Getter
@AllArgsConstructor
public enum SingerSexEnum {
    MALE(0, "女"),
    FEMALE(1, "男"),
    GROUP(2, "音乐组合"),
    VARIOUS(3, "群星"),
    UNKNOWN(4, "未知"),
    ;

    private Integer code;
    private String desc;

    public static SingerSexEnum getByCode(Integer code) {
        return Arrays.stream(values()).filter(item -> item.getCode().equals(code))
                .findFirst().orElse(null);
    }
}
