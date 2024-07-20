package com.feng.music.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author linqf
 * @description
 * @date 2024-07-18
 */
@Getter
@Setter
public class EchartsViewResp implements Serializable {
    @Serial
    private static final long serialVersionUID = 8507480283029793567L;

    /**
     * 横坐标
     */
    @JsonProperty("xAxis")
    private Object xAxis;
    /**
     * 纵坐标
     */
    @JsonProperty("yAxis")
    private Object yAxis;
    /**
     * 图例
     */
    private Object legend;
    /**
     * 数据
     */
    private Object series;
}
