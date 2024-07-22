/**
 * Copyright (C), 2015-2024, XXX有限公司
 * FileName: BeanConfig
 * Author:   Lynn
 * Date:     2024/7/20 19:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.feng.music.basic.config;

import com.feng.music.common.config.WebMvcConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Lynn
 * @create 2024/7/20
 */
@Configuration
public class BeanConfig {

    @Bean
    public WebMvcConfiguration webMvcConfiguration() {
        return new WebMvcConfiguration();
    }
}

