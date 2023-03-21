package com.junhwa.blog.common.config;

import com.junhwa.blog.property.KakaoProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class KakaoConfig {

    private final KakaoProperties kakaoProperties;

    @Bean
    public WebClient kakaoWebClient() {
        return WebClient.builder()
                .baseUrl(kakaoProperties.getBaseApiUrl())
                .defaultHeader("Authorization","KakaoAK "+ kakaoProperties.getRestApiKey())
                .build();
    }
}
