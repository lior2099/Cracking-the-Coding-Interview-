package il.co.ilrd.book.Recursion.test;

import il.co.ilrd.book.Recursion.PaintFill;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaintFillTest {

    @Test
    void testPaintFillBasic() {
        PaintFill.Color[][] screen = {
                {PaintFill.Color.BLACK, PaintFill.Color.BLACK, PaintFill.Color.RED},
                {PaintFill.Color.BLACK, PaintFill.Color.BLACK, PaintFill.Color.RED},
                {PaintFill.Color.RED, PaintFill.Color.RED, PaintFill.Color.RED}
        };

        PaintFill.paintAreaFill(screen, 1, 1, PaintFill.Color.GREEN);

        assertArrayEquals(new PaintFill.Color[][]{
                {PaintFill.Color.GREEN, PaintFill.Color.GREEN, PaintFill.Color.RED},
                {PaintFill.Color.GREEN, PaintFill.Color.GREEN, PaintFill.Color.RED},
                {PaintFill.Color.RED, PaintFill.Color.RED, PaintFill.Color.RED}
        }, screen);
    }

    @Test
    void testPaintFillEdge() {
        PaintFill.Color[][] screen = {
                {PaintFill.Color.RED, PaintFill.Color.RED, PaintFill.Color.RED},
                {PaintFill.Color.RED, PaintFill.Color.BLACK, PaintFill.Color.RED},
                {PaintFill.Color.RED, PaintFill.Color.RED, PaintFill.Color.RED}
        };

        PaintFill.paintAreaFill(screen, 0, 0, PaintFill.Color.ORANGE);

        assertArrayEquals(new PaintFill.Color[][]{
                {PaintFill.Color.ORANGE, PaintFill.Color.ORANGE, PaintFill.Color.ORANGE},
                {PaintFill.Color.ORANGE, PaintFill.Color.BLACK, PaintFill.Color.ORANGE},
                {PaintFill.Color.ORANGE, PaintFill.Color.ORANGE, PaintFill.Color.ORANGE}
        }, screen);
    }

    @Test
    void testPaintFillNoChange() {
        PaintFill.Color[][] screen = {
                {PaintFill.Color.BLUE, PaintFill.Color.BLUE, PaintFill.Color.RED},
                {PaintFill.Color.BLUE, PaintFill.Color.BLUE, PaintFill.Color.RED},
                {PaintFill.Color.RED, PaintFill.Color.RED, PaintFill.Color.RED}
        };

        PaintFill.paintAreaFill(screen, 2, 2, PaintFill.Color.RED); // Same color as oldColor

        assertArrayEquals(new PaintFill.Color[][]{
                {PaintFill.Color.BLUE, PaintFill.Color.BLUE, PaintFill.Color.RED},
                {PaintFill.Color.BLUE, PaintFill.Color.BLUE, PaintFill.Color.RED},
                {PaintFill.Color.RED, PaintFill.Color.RED, PaintFill.Color.RED}
        }, screen);
    }

    @Test
    void testInvalidPoint() {
        PaintFill.Color[][] screen = {
                {PaintFill.Color.YELLOW, PaintFill.Color.YELLOW, PaintFill.Color.RED},
                {PaintFill.Color.YELLOW, PaintFill.Color.YELLOW, PaintFill.Color.RED},
                {PaintFill.Color.RED, PaintFill.Color.RED, PaintFill.Color.RED}
        };

        PaintFill.paintAreaFill(screen, -1, -1, PaintFill.Color.GREEN); // Invalid point

        assertArrayEquals(new PaintFill.Color[][]{
                {PaintFill.Color.YELLOW, PaintFill.Color.YELLOW, PaintFill.Color.RED},
                {PaintFill.Color.YELLOW, PaintFill.Color.YELLOW, PaintFill.Color.RED},
                {PaintFill.Color.RED, PaintFill.Color.RED, PaintFill.Color.RED}
        }, screen);
    }
}
