package com.shengda.oauth2.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-01-31
 */
@Getter
@RefreshScope
@ConfigurationProperties(prefix = "spring.security")
public class SecurityProperties implements Serializable {

    private static final long serialVersionUID = -4750202980091591676L;

    private AuthProperties auth = new AuthProperties();

    private PermitProperties ignore = new PermitProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

}
