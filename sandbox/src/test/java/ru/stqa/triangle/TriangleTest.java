package ru.stqa.triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void canCalculateArea(){
        var s = new Triangle(5.0, 6.0, 7.0);
        double result = s.triangleArea();
        Assertions.assertEquals(14.696938456699069, result);
    }
    @Test
    void canCalculatePerimeter(){
               Assertions.assertEquals(18, new Triangle(5.0, 6.0, 7.0).trianglePerimeter());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide(){
        try {
            new Triangle(-3, 5, 6);
            Assertions.fail();
        } catch(IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void cannotCreateTriangleWithWrongSumOfSides() {
        try{
            new Triangle(3,2,20);
            Assertions.fail();
        } catch(IllegalArgumentException exception) {
            //OK
        }
    }
}
