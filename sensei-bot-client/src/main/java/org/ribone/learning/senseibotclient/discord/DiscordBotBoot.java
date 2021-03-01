package org.ribone.learning.senseibotclient.discord;

import net.dv8tion.jda.api.JDA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DiscordBotBoot {
    // Why logger is private, static, and final: https://rules.sonarsource.com/java/tag/convention/RSPEC-1312
    // getLogger(...) creates a logger instance with the name of `...`
    private static final Logger logger = LoggerFactory.getLogger(DiscordBotBoot.class);

    private static JDA jda;

    public void start(){

    }
}
