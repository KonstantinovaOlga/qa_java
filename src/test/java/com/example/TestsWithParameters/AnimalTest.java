package com.example.TestsWithParameters;

import com.example.Animal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {
    private Animal animal;
    private final String kindAnimal;
    private final List<String> animalFoods;

    public AnimalTest(String kindAnimal, List<String> animalFoods) {
        this.kindAnimal = kindAnimal;
        this.animalFoods = animalFoods;
    }

    @Parameterized.Parameters(name = "Проверка: {0} ест {1}")
    public static Object[][] getAnimalData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Before
    public void setUp() {
        this.animal = new Animal();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actualFoods = animal.getFood(kindAnimal);
        assertEquals(animalFoods, actualFoods);
    }
}