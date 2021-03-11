package org.ribone.learning.senseibotclient.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

@Component
public class BotBootUp {
    // Why logger is private, static, and final: https://rules.sonarsource.com/java/tag/convention/RSPEC-1312
    // getLogger(...) creates a logger instance with the name of `...`
    private static final Logger logger = LoggerFactory.getLogger(BotBootUp.class);
    private static JDA jda;
    private final BotConfig config;

    @Autowired
    public BotBootUp(BotConfig config){
        this.config = config;
    }

    public void start(){
        logger.info("Building da bot...");
        runDiscordBot(config.getBotToken());
        logger.info("Running da bot...");
    }

    private void runDiscordBot(String token){
        try{
            jda = JDABuilder
                    .createDefault(token)
                    .build();
        } catch(LoginException e){
            logger.error("Error! Check your config details");
            logger.error(e.getMessage());
        }
    }
}
