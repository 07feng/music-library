/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: QueryWrapperBuilder
 * Author:   Lynn
 * Date:     2024/6/29 17:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.common.builder;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * 〈一句话功能简述〉
 * 〈构造queryBuilder〉
 *
 * @author Lynn
 * @create 2024/6/29
 */
public class QueryWrapperBuilder<T> {

    public QueryWrapper<T> build(T entity) throws IllegalAccessException {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            field.setAccessible(true);
            Object value = field.get(entity);
            if (Objects.nonNull(value)) {
                String columnName = getColumnName(field.getName());
                queryWrapper.eq(columnName, value);
            }
        }
        return queryWrapper;
    }

    private static String getColumnName(String name) {
        StringBuffer sb = new StringBuffer();
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char item = chars[i];
            //大写字母
            if (item > 65 && item < 90) {
                sb.append("_");
                sb.append((char) (item + 32));
            } else {
                sb.append(item);
            }
        }
        return sb.toString();
    }
}
