package com.example;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimalTest   {

    private Animal animal;

    @Before
    public void setUp() {
        this.animal = new Animal();
    }

    @Test
    public void testGetFamily() {
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",this.animal.getFamily());
    }

    @Test (expected=Exception.class)
    public void testGetFoodException() throws Exception {
        List<String> actualFoods=animal.getFood("Не определился");
    }
}