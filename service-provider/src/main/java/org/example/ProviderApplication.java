package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope // 不加这个不会动态刷新
public class ProviderApplication {

    @Value("${name}")
    private String name;
    @Value("${common}")
    private String common;

    /**
     * http://localhost:8088/service-provider/getName
     * @return
     */
    @RequestMapping("/getName")
    public String getName() {
        return name + "---" + common + "---" + DodbConstants.appKey;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
