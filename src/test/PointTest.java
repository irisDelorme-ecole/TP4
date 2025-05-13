package test;

import geometry.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @BeforeAll
    static void beforeAll() {
        p1 = new Point(0,0);
        p2 = new Point(1,2);
        p3 = new Point(-3,-5);
        p4 = new Point(1,-1);
        p5 = new Point(1,-1);
    }
    static Point p1;
    static Point p2;
    static Point p3;
    static Point p4;
    static Point p5;

    @org.junit.jupiter.api.Test
    void getX() {
        assertEquals(0,p1.getX());
        assertEquals(1,p2.getX());
        assertEquals(-3,p3.getX());
        assertEquals(1,p4.getX());
    }

    @org.junit.jupiter.api.Test
    void getY() {
        assertEquals(0,p1.getY());
        assertEquals(2,p2.getY());
        assertEquals(-5,p3.getY());
        assertEquals(-1,p4.getY());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        assertFalse(p1.equals(p2));
        assertTrue(p4.equals(p5));
        assertFalse(p3.equals(null));
        assertTrue(p4.equals(p4));
    }
}