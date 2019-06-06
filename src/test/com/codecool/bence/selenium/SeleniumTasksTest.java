package com.codecool.bence.selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeleniumTasksTest {

    private static SeleniumTasks st;

    @BeforeAll
    static void setup(){
        st = new SeleniumTasks();
    }

    @Test
    void singleFieldAndButton() {
        assertEquals("15", st.twoFieldsAndButton("5", "10"));
    }

    @Test
    void singleFiendAndButton() {
        assertEquals("Hello World", st.singleFiendAndButton("Hello World"));
    }
}