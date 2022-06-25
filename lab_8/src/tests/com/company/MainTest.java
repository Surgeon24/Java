package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void addition(){
        String[] args = new String[]{"3+4"};
        assertEquals(7, Main.solveEquation(args[0]));
    }

    @Test
    void subtraction(){
        String[] args = new String[]{"2-5"};
        assertEquals(-3, Main.solveEquation(args[0]));
    }

    @Test
    void division(){
        String[] args = new String[]{"2/8"};
        assertEquals(0.25, Main.solveEquation(args[0]));
    }

    @Test
    void multiplication(){
        String[] args = new String[]{"7*8"};
        assertEquals(56, Main.solveEquation(args[0]));
    }

    @Test
    void complicated1(){
        String[] args = new String[]{"7+8*2"};
        assertEquals(23, Main.solveEquation(args[0]));
    }

    @Test
    void complicated2(){
        String[] args = new String[]{"(3+4)*11"};
        assertEquals(77, Main.solveEquation(args[0]));
    }

    @Test
    void complicated3(){
        String[] args = new String[]{"(3+4)*10/2"};
        assertEquals(35, Main.solveEquation(args[0]));
    }

    @Test
    void complicated4(){
        String[] args = new String[]{"5*(3+4)/2"};
        assertEquals(17.5, Main.solveEquation(args[0]));
    }

    @Test
    void complicated5(){
        String[] args = new String[]{"100/(3+17)*8"};
        assertEquals(40, Main.solveEquation(args[0]));
    }

    @Test
    void complicated6(){
        String[] args = new String[]{"0.8/2+0.6"};
        assertEquals(1, Main.solveEquation(args[0]));
    }
}