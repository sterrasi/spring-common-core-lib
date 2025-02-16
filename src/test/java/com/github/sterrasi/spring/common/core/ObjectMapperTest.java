package com.github.sterrasi.spring.common.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sterrasi.spring.core.ObjectMapperProvider;
import com.github.sterrasi.spring.core.config.SerializationConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = {SerializationConfiguration.class})
class ObjectMapperTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter msgConverter;

    /**
     * {@link ObjectMapper} is the same as the {@link com.github.sterrasi.spring.core.ObjectMapperProvider}s
     */
    @Test
    @DisplayName("The injected ObjectMapper is from the ObjectMapperProvider")
    void injectedMapperIsFromObjectMapperProvider() {
        assertThat(objectMapper).isNotNull();
        assertThat(objectMapper).isSameAs(ObjectMapperProvider.get());
    }

    /**
     * {@link ObjectMapper} is the same as the {@link com.github.sterrasi.spring.core.ObjectMapperProvider}s
     */
    @Test
    @DisplayName("The message converter's ObjectMapper is from the ObjectMapperProvider")
    void msgConverterMapperIsFromObjectMapperProvider() {
        assertThat(msgConverter).isNotNull();
        assertThat(msgConverter.getObjectMapper()).isSameAs(ObjectMapperProvider.get());
    }

}
