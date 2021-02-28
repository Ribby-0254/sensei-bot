package org.ribone.learning.senseibotclient;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

import org.springframework.boot.CommandLineRunner;

public class DiscordBotRunner implements CommandLineRunner {

    private static JDA jda;

    @Override
    public void run(String ...args){
        try{
            jda = JDABuilder.build();
        } catch (LoginException e){
            System.out.println("ERROR! Check your configuration details in discordbot.properties");
        }
    }
}
