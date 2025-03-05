package com.bender;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.stripe")
public class StripeConfig {

    private String url;
    private String apiKey;

    public StripeConfig() {
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        return "StripeConfig{" +
                "url='" + url + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }
}
