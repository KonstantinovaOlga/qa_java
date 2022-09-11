package com.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest extends TestCase {

    private Feline feline;

    @Spy
    Feline felineSpy;

    @Before
    public void setUp() {
        this.feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        Mockito.when(felineSpy.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFoods = felineSpy.eatMeat();
        List<String> expectedFoods = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFoods, actualFoods);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, this.feline.getKittens());
    }
}