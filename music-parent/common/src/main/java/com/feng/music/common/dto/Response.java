/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: Response
 * Author:   Lynn
 * Date:     2024/6/29 18:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
@Getter
@Setter
public class Response<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -4432451298302139017L;

    private Integer code;
    private String message;
    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setCode(200);
        response.setMessage("成功");
        response.setData(data);
        return response;
    }
}

