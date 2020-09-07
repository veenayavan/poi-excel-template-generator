package com.main.test.config.properties;

import com.main.test.properties.TemplateProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "client.template")
public class ClientTemplateConfiguration {

    private Map<Long, TemplateProperties> config = new HashMap<>();

    public Map<Long, TemplateProperties> getConfig() {
        return config;
    }

    public void setConfig(Map<Long, TemplateProperties> config) {
        this.config = config;
    }
}
