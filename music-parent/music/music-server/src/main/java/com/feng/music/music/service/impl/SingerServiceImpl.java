/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: SingerServiceImpl
 * Author:   Lynn
 * Date:     2024/6/29 18:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.music.service.impl;

import cn.hutool.json.JSONUtil;
import com.feng.music.common.dto.EchartsViewResp;
import com.feng.music.common.enums.SingerSexEnum;
import com.feng.music.common.service.impl.AbstractBaseService;
import com.feng.music.music.dto.singer.SingerResp;
import com.feng.music.music.mapper.SingerMapper;
import com.feng.music.music.po.Singer;
import com.feng.music.music.service.SingerService;
import org.apache.commons.collections4.CollectionUtils;
import org.icepear.echarts.Bar;
import org.icepear.echarts.Pie;
import org.icepear.echarts.charts.bar.BarDataItem;
import org.icepear.echarts.charts.bar.BarLabel;
import org.icepear.echarts.charts.bar.BarSeries;
import org.icepear.echarts.charts.pie.PieDataItem;
import org.icepear.echarts.charts.pie.PieLabel;
import org.icepear.echarts.components.legend.Legend;
import org.icepear.echarts.render.Engine;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
@Service
public class SingerServiceImpl extends AbstractBaseService<Singer, Long, SingerMapper> implements SingerService {

    @Override
    public List<SingerResp> getAllSinger() {
        List<Singer> singerList = selectAll();
        return singerList.stream().map(Singer::convertToSingerResp).collect(Collectors.toList());
    }

    @Override
    public EchartsViewResp getSingerSexRadio() {
        List<Singer> singerList = selectAll();
        if (CollectionUtils.isEmpty(singerList)) {
            return new EchartsViewResp();
        }
        Map<Integer, List<Singer>> singerSexMap = singerList.stream().collect(Collectors.groupingBy(Singer::getSex));
        PieDataItem[] pieDataItemArr = convertToPieDataItemArr(singerSexMap, singerList.size());
        List<String> nameList = Arrays.stream(SingerSexEnum.values()).map(SingerSexEnum::getDesc).collect(Collectors.toList());
        Pie pie = new Pie()
                .setLegend(new Legend().setOrient("vertical").setLeft("left").setData(nameList.toArray(new String[0])))
                .addSeries(pieDataItemArr);
        Engine engine = new Engine();
        String dataJson = engine.renderJsonOption(pie.getOption());
        return JSONUtil.toBean(dataJson, EchartsViewResp.class);
    }

    @Override
    public EchartsViewResp getSingerCountryStatistics() {
        List<Singer> singerList = selectAll();
        if (CollectionUtils.isEmpty(singerList)) {
            return new EchartsViewResp();
        }
        Map<String, List<Singer>> locationMap = singerList.stream().collect(Collectors.groupingBy(Singer::getLocation));
        Set<String> locationSet = locationMap.keySet();
        Bar bar = new Bar()
                .addXAxis(locationSet.toArray(new String[0]))
                .addYAxis()
                .addSeries(new BarSeries().setData(convertToBarDataItem(locationMap)));
        Engine engine = new Engine();
        String dataJson = engine.renderJsonOption(bar.getOption());
        return JSONUtil.toBean(dataJson, EchartsViewResp.class);
    }

    private BarDataItem[] convertToBarDataItem(Map<String, List<Singer>> singerLocationMap) {
        List<BarDataItem> barDataItemList = new ArrayList<>();
        for (Map.Entry<String, List<Singer>> entry : singerLocationMap.entrySet()) {
            BarDataItem barDataItem = new BarDataItem()
                    .setLabel(new BarLabel().setShow(true).setPosition("outside"))
                    .setName(entry.getKey())
                    .setValue(entry.getValue().size());
            barDataItemList.add(barDataItem);
        }
        return barDataItemList.toArray(new BarDataItem[0]);
    }

    private PieDataItem[] convertToPieDataItemArr(Map<Integer, List<Singer>> singerSexMap, int singerTotal) {
        List<PieDataItem> pieDataItemList = new ArrayList<>();
        for (Map.Entry<Integer, List<Singer>> entry : singerSexMap.entrySet()) {
            int size = entry.getValue().size();
            MathContext mc = new MathContext(4, RoundingMode.HALF_UP);
            BigDecimal proportion = new BigDecimal(size).divide(new BigDecimal(singerTotal), mc);
            PieDataItem pieDataItem = new PieDataItem()
                    .setValue(proportion)
                    .setLabel(new PieLabel().setShow(true).setFormatter("{d}%"));
            SingerSexEnum sexEnum = SingerSexEnum.getByCode(entry.getKey());
            pieDataItem.setName(sexEnum.getDesc());
            pieDataItemList.add(pieDataItem);
        }
        return pieDataItemList.toArray(new PieDataItem[0]);
    }
}

