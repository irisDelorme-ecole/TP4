package tests;

import code.Point;
import code.Triangle;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {

    @org.junit.jupiter.api.Test
    void dotProduct() {
        Point p =new Point(0,1);
        Point p2 =new Point(0,3);
        Point p3 =new Point(1, 2);
        Point p4 =new Point(-1, 2);
        Point p5 =new Point(-1, 2);

        assertEquals(6, Triangle.dotProduct(p3,p2));
        assertEquals(3, Triangle.dotProduct(p,p2));
        assertEquals(3, Triangle.dotProduct(p3,p4));
        assertEquals(5, Triangle.dotProduct(p5,p4));
    }

    @org.junit.jupiter.api.Test
    void containsOrigin() {
        HashSet set = new HashSet<Point>();
        set.add(new Point(-1,0));
        set.add(new Point(1,1));
        set.add(new Point(0,-1));

        Triangle t1 = new Triangle(set);
        set.clear();
        set.add(new Point(-1,-1));
        set.add(new Point(1,-1));
        set.add(new Point(1,1));

        Triangle t2 = new Triangle(set);
        set.clear();
        set.add(new Point(-1,0));
        set.add(new Point(1,1));
        set.add(new Point(0,-1));


        Triangle t3 = new Triangle(set);
        assertTrue(t1.containsOrigin());
        assertFalse(t2.containsOrigin());
        assertFalse(t3.containsOrigin());






    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Point p = new Point(0,0);
        Point p2 = new Point(0,0);
        Point p3 = new Point(0,1);
        Point p4 = new Point(0,-1);
        Point p5 = new Point(0,-1);
        assertTrue(p.equals(p2));
        assertFalse(p.equals(p3));
        assertFalse(p.equals(p4));
        assertFalse(p.equals(p5));
    }
}