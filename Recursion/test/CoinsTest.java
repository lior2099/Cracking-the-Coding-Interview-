package Recursion.test;

import Recursion.Coins;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinsTest {

    @Test
    void test10Cents() {
        Assertions.assertEquals(4, Coins.waysForNCent(10), "10 cents should have 4 unique ways.");
    }

    @Test
    void test25Cents() {
        assertEquals(13, Coins.waysForNCent(25), "25 cents should have 13 unique ways.");
    }

    @Test
    void test0Cents() {
        assertEquals(0, Coins.waysForNCent(0), "0 cents should have exactly 1 way (no coins).");
    }

    @Test
    void test5Cents() {
        assertEquals(2, Coins.waysForNCent(5), "5 cents should have 2 unique ways (5, or 1+1+1+1+1).");
    }

    @Test
    void test100Cents() {
        assertEquals(242, Coins.waysForNCent(100), "100 cents should have 242 unique ways.");
    }
}
