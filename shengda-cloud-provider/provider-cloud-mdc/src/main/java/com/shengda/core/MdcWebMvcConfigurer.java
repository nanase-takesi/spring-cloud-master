package com.shengda.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author takesi
 * @date 2020-03-19
 */
@Configuration
public class MdcWebMvcConfigurer implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(MdcWebMvcConfigurer.class);

}
