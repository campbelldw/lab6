package com.example.lab4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private ThymeController thymeController;

    @Test
    public void ThymeLoads() throws Exception {
        assertThat(thymeController).isNotNull();
    }

}