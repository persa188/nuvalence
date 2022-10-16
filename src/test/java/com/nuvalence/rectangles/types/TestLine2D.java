package com.nuvalence.rectangles.types;

import org.junit.jupiter.api.Test;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLine2D {

    /*
     * this test suite could be more comprehensive, but left it as bare minimum due to time. The edge cases
     * are tested indirectly via the rectangle & line engines.
     */
    @Test
    public void testSlopeInterceptForm() {
        final Line2D line = new Line2D(new Coordinate2D(0, 0), new Coordinate2D(5,5));
        assertEquals(line.getIntercept(), 0);
        assertEquals(line.getSlope(), 1);
    }

    @Test
    public void testSlopeInterceptFormWhenVerticalLine() {
        final Line2D line = new Line2D(new Coordinate2D(0, 0), new Coordinate2D(0,5));

        // vertical lines DO NOT have a y-intercept, this seems reasonable.
        assertEquals(line.getIntercept(), NaN);

        // vertical lines will always have undefined slope, so +/- inifinity is reasonable.
        assertEquals(line.getSlope(), Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testSlopeInterceptFormWhenHorizontalLine() {
        final Line2D line = new Line2D(new Coordinate2D(5, 0), new Coordinate2D(0,0));
        assertEquals(line.getIntercept(), 0);

        // vertical lines will always have undefined slope.
        assertEquals(line.getSlope(), 0);
    }

    @Test
    public void testStandardFormOfLineHappyPath() {
        final Line2D line = new Line2D(new Coordinate2D(5, 0), new Coordinate2D(0,0));
        assertEquals(line.getA(), 0);
        assertEquals(line.getB(), 5.0);
        assertEquals(line.getC(), 0);
    }
}
