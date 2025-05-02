package tests;

import code.Cercle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CercleTest {

    @Test
    void setAllTriangles() {
        Cercle c = new Cercle(2);
        assertEquals((9*8*7*6*5*4*3*2*1)/((3*2)*(6*5*4*3*2)), c.getNumTriangles());
    }//5!/3!(5−3)!
}