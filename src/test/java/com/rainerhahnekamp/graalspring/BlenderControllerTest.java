package com.rainerhahnekamp.graalspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@SpringBootTest(properties = {"app.blenderClass=com.rainerhahnekamp.graalspring.BlenderImpl"})
class BlenderControllerTest {
    @Autowired
    BlenderController controller;

    @Test
    void testBlendShouldNotThrow() {
        assertDoesNotThrow(() -> controller.blend());
    }
}