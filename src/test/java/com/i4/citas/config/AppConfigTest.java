package com.i4.citas.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ResourceBundleMessageSource;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class AppConfigTest {

    /**
     * Method under test: {@link AppConfig#messageSource()}
     */
    @Test
    void testMessageSource() {

        // Arrange, Act and Assert
        assertInstanceOf(ResourceBundleMessageSource.class, (new AppConfig()).messageSource());
    }
}
