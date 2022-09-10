package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest  {

    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void setUp() {
        this.cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", this.cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFoods=this.cat.getFood();
        List<String> expectedFoods=List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFoods,actualFoods);
    }

}