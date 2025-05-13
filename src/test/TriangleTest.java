package test;

import geometry.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @BeforeAll
    static void beforeAll() {
        HashSet<Point> som = new HashSet<>();
        som.add(new Point(1,1));
        som.add(new Point(-1,1));
        som.add(new Point(0,-1));
        t = new Triangle(som);

        som.clear();
        som.add(new Point(-1,-1));
        som.add(new Point(-1,1));
        som.add(new Point(-1,0));
        t2 = new Triangle(som);
    }
    static Triangle t;
    static Triangle t2;
    @Test
    void containsOrigin() {
        assertTrue(t.containsOrigin());
        assertFalse(t2.containsOrigin());
    }

    @Test
    void getSommets() {
        assertTrue(t.getSommets().contains(new Point(0,-1)));
        assertFalse(t.getSommets().contains(new Point(0,0)));
    }
}