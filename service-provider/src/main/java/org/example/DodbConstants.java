package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DodbConstants {
    public static String appKey;

    // 这种方式nacos不会自动刷新配置
    @Value("${appKey}")
    public  void setAppKey(String appKey) {
        DodbConstants.appKey = appKey;
    }

}
