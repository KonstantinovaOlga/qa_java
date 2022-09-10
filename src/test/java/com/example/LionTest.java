package com.example;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest extends TestCase {

    @Mock
    Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        Lion lion = new Lion("Самка",feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFoods=lion.getFood();
        List<String> expectedFoods=List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFoods,actualFoods);
    }

    @Test (expected=Exception.class)
    public void testLionException() throws Exception {
        Feline felineObj = new Feline();
        Lion lion = new Lion("Не определился",felineObj);
    }

}