package org.ribone.learning.senseibotclient.discord;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DiscordBotRunner implements CommandLineRunner {

    private final DiscordBotBoot bot;

    @Autowired
    public DiscordBotRunner(DiscordBotBoot bot){
        this.bot = bot;
    }

    @Override
    public void run(String ...args){

    }
}
