package com.example.TestsWithParameters;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private final String Sex;
    private final boolean hasMane;

    public LionTest(String Sex, boolean hasMane) {
        this.Sex = Sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Проверка: пол - {0}, hasMane={1}")
    public static Object[][] getFelineData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(Sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }
}