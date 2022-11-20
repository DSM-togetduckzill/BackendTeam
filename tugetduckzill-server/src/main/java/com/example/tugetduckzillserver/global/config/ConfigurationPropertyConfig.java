package com.example.tugetduckzillserver.global.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@ConfigurationPropertiesScan("com.example.tugetduckzillserver") // 특정 yml 파일 설정을 불러온다
@Configuration // 설정파일을 만들기 위해 or Bean을 등록하기 위해
public class ConfigurationPropertyConfig {

}
