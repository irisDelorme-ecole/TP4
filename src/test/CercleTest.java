package test;

import geometry.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CercleTest {
    @BeforeAll
    static void beforeAll() {
        c = new Cercle(2);
        c2 = new Cercle(3);
        c3 = new Cercle(5);
    }

    static Cercle c;
    static Cercle c2;
    static Cercle c3;

    @Test
    public void testPointsInt() {
        Point p = new Point(-2, -2);
        assertFalse(c.getPointsInt().contains(p));//does not contain point outside of circle
        assertTrue(c2.getPointsInt().contains(p)); //does contain correct point
    }

    @Test
    public void testNumUniques() {
        assertEquals(8, c.getNumUniques());
        assertEquals(360, c2.getNumUniques());
        assertEquals(10600, c3.getNumUniques());
    }

}