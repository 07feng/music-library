package com.feng.music.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootTest
@RefreshScope
class GatewayServerApplicationTests {

    @Value("${spring.cloud.gateway.discovery.locator.enabled}")
    private Boolean enabled;

    @Test
    void contextLoads() {
        System.out.println("enabled: " + enabled);
    }

}
