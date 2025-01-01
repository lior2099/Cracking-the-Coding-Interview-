package il.co.ilrd.book.bit.testing;

import il.co.ilrd.book.bit.Insertion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionTest {

    @Test
    public void testStandardInsertion() {
        Insertion insertion = new Insertion();
        int N = Integer.parseInt("10000000000", 2); // 1024 in decimal
        int M = Integer.parseInt("10011", 2);      // 19 in decimal
        int result = insertion.updateBits(N, M, 2, 6);
        assertEquals(Integer.parseInt("10001001100", 2), result); // Expected: 1100 in binary
    }

    @Test
    void test2() {
        int N = Integer.parseInt("10000000000", 2); // Binary to int (1024)
        int M = Integer.parseInt("10011", 2);      // Binary to int (19)
        int i = 2;
        int j = 6;

        Insertion insertion = new Insertion();
        int result = insertion.updateBits(N, M, i, j);

        // Print binary result for verification
        System.out.println("Binary Result: " + Integer.toBinaryString(result));

        // Check that the result matches 10001001100 in binary, which is 1100 in decimal
        assertEquals(Integer.parseInt("10001001100", 2), result);
    }


    @Test
    public void testNonOverlappingInsertion() {
        Insertion insertion = new Insertion();
        int N = Integer.parseInt("11111111111", 2); // 2047 in decimal
        int M = Integer.parseInt("101", 2);         // 5 in decimal
        int result = insertion.updateBits(N, M, 3, 5);
        assertEquals(Integer.parseInt("11111101111", 2), result); // Expected: 1983 in decimal
    }

    @Test
    public void testSingleBitReplacement() {
        Insertion insertion = new Insertion();
        int N = Integer.parseInt("10000000000", 2); // 1024 in decimal
        int M = Integer.parseInt("1", 2);           // 1 in decimal
        int result = insertion.updateBits(N, M, 5, 5);
        assertEquals(Integer.parseInt("10000100000", 2), result); // Expected: 1040 in decimal
    }

    @Test
    public void testZeroInsertion() {
        Insertion insertion = new Insertion();
        int N = Integer.parseInt("10101010101", 2); // 1365 in decimal
        int M = 0;
        int result = insertion.updateBits(N, M, 3, 6);
        assertEquals(Integer.parseInt("10100000101", 2), result); // Expected: 1365
    }

    @Test
    public void testFullInsertion() {
        Insertion insertion = new Insertion();
        int N = 0;                                  // All bits 0
        int M = Integer.parseInt("11111111111", 2); // 2047 in decimal
        int result = insertion.updateBits(N, M, 0, 10);
        assertEquals(Integer.parseInt("11111111111", 2), result); // Expected: 2047
    }
}
