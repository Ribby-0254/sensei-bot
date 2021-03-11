package org.ribone.learning.senseibotclient.discord;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Sole purpose: To startup the discord bot

@Component
public class BotRunner implements CommandLineRunner {

    private final BotBootUp bot;

    @Autowired
    public BotRunner(BotBootUp bot){
        this.bot = bot;
    }

    @Override
    public void run(String ...args){
        // connect bot
        bot.start();
    }
}
