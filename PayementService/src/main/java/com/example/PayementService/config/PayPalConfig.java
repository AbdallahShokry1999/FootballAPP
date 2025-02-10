package com.example.PayementService.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PayPalConfig {

    @Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    @Value("${paypal.mode}")
    private String mode;

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        return new APIContext(new OAuthTokenCredential(clientId, clientSecret, getPayPalSDKConfig()).getAccessToken());
    }

    private Map<String, String> getPayPalSDKConfig() {
        Map<String, String> config = new HashMap<>();
        config.put("mode", mode);
        return config;
    }
}
