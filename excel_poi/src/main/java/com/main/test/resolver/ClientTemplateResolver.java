package com.main.test.resolver;

import com.main.test.config.properties.ClientTemplateConfiguration;
import com.main.test.properties.TemplateProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("clientTemplateResolver")
@EnableConfigurationProperties(ClientTemplateConfiguration.class)
public class ClientTemplateResolver {

    @Autowired
    private ClientTemplateConfiguration clientTemplateConfiguration;

    public TemplateProperties resolve(Long id) {
        TemplateProperties properties = clientTemplateConfiguration.getConfig().get(id);
        if (properties == null) {
            throw new RuntimeException(String.format("No template properties configured for client with id : %d", id));
        }
        return properties;
    }


}
