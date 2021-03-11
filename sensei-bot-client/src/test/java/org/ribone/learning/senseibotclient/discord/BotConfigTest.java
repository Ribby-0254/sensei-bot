package org.ribone.learning.senseibotclient.discord;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotConfigTest {

    private BotConfig config;

    @BeforeEach
    void setUp(){
        config = new BotConfig();
    }


    @DisplayName("Test BotConfig reads from properties file")
    @Test
    void getBotTokenTest() {
        assertNotNull(config.getBotToken());
    }
}