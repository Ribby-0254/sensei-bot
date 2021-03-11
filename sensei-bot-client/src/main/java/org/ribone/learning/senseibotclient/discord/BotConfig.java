package org.ribone.learning.senseibotclient.discord;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:bot.properties")
public class BotConfig {
    @Value("${token:test}")
    private String botToken;

    public String getBotToken(){
        return botToken;
    }
}
