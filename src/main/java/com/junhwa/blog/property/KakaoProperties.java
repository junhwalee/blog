package com.junhwa.blog.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application.provider.kakao")
public class KakaoProperties {

    private String baseApiUrl;
    private String restApiKey;
    private String javascriptKey;
    private String adminKey;
}
