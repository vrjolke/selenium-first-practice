package com.codecool.bence.selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumTasksTest {

    private static SeleniumTasks st;

    @BeforeAll
    static void setup(){
        st = new SeleniumTasks();
    }

    @Test
    void datePicker() {
        assertEquals(1, st.datePicker(2019, "Jan", 14));
    }

    @Test
    void testNavigateToSimpleForms() {
        assertEquals("https://www.seleniumeasy.com/test/basic-first-form-demo.html", st.navigateToSimpleForms());
    }

    @Test
    void testSingleFiendAndButton() {
        assertEquals("Hello World", st.singleFiendAndButton("Hello World"));
    }

    @Test
    void testTwoFieldsAndButton() {
        assertEquals("15", st.twoFieldsAndButton("5", "10"));
    }

    @Test
    void testTwoFieldsAndButtonWithLargeNumbers() {
        assertEquals("10000000000000000000000", st.twoFieldsAndButton("5000000000000000000000", "5000000000000000000000"));
    }

    @Test
    void testSingleCheckbox() {
        assertEquals("Success - Check box is checked", st.singleCheckbox());
    }

    @Test
    void testMultipleCheckboxCheckAll() {
        assertEquals(true, st.multipleCheckboxCheckAll());
    }

    @Test
    void testMultipleCheckboxUncheckAll() {
        assertEquals(true, st.multipleCheckboxUncheckAll());
    }

    @Test
    void testMultipleCheckboxUncheckOne() {
        assertEquals("Check All", st.multipleCheckboxUncheckOne());
    }

    @Test
    void testSelectList() {
        assertEquals("Day selected :- Tuesday", st.selectList());
    }

    @Test
    void testSelectListAlternative() {
        assertEquals("Day selected :- Tuesday", st.selectListAlternative());
    }

    @Test
    void testGroupRadioButtons() {
        String[] expected = {"Sex : Male\n" +
                "Age group: 0 - 5","Sex : Female\n" +
                "Age group: 15 - 50"};
        assertArrayEquals(expected, st.groupRadioButtons());
    }


    @Test
    void sortAndSearchSum() {
        assertEquals(1164, st.sortAndSearchSum());
    }
}
