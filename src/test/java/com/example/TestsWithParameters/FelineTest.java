package com.example.TestsWithParameters;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int amountKittens;

    public FelineTest(int amountKittens) {
        this.amountKittens = amountKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getFelineData() {
        return new Object[][]{
                {0},
                {1},
                {5},
                {10},
                {100},
        };
    }

    @Test
    public void testGetKitten() {
        Feline feline = new Feline();
        assertEquals(amountKittens, feline.getKittens(amountKittens));
    }
}