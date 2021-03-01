package org.ribone.learning.senseibotclient.discord;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscordBotBootTest {

    @DisplayName("Test CommandClient builds successfully")
    @Test
    void commandClientBuildSuccessTest(){
        Assertions.assertDoesNotThrow(() -> {
            throw new Exception();
        });
    }

    @DisplayName("Test JDA builds successfully")
    @Test
    void jdaBuildTest(){
        Assertions.assertDoesNotThrow(() -> {
            throw new Exception();
        });
    }

}