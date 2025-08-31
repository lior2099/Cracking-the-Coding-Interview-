import bit.BinarytoString;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryToStringTest {
    @Test
    void testValidBinary() {
        BinarytoString converter = new BinarytoString();

        assertEquals("0.101", converter.printBinary(0.625));
        assertEquals("0.1", converter.printBinary(0.5));
        assertEquals("0.01", converter.printBinary(0.25));
        assertEquals("0.10010001", converter.printBinary(0.56640625)); //1/2 + 1/16 + 1/256
    }

    @Test
    void testErrorCase() {
        BinarytoString converter = new BinarytoString();

        assertEquals("ERROR", converter.printBinary(0.72));
        assertEquals("ERROR", converter.printBinary(1.0));
        assertEquals("ERROR", converter.printBinary(0.0));
    }
}
