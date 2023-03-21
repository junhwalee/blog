package com.junhwa.blog.common.config;

import com.junhwa.blog.property.KakaoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties({
        KakaoProperties.class
})
@PropertySource(value = {"classpath:/application-provider.yml"}, factory = YamlLoadFactory.class)
public class PropertiesConfig {
}
