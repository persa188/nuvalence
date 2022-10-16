package com.nuvalence.rectangles.engine;

import com.nuvalence.rectangles.types.Coordinate2D;
import com.nuvalence.rectangles.types.Line2D;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLineComparisonEngineImpl {
    LineComparisonEngine sut = new LineComparisonEngineImpl();

    @Test
    public void testContainsHappyPath() {
        final Line2D a = new Line2D(new Coordinate2D(0, 0), new Coordinate2D(1, 1));
        final Line2D b = new Line2D(new Coordinate2D(0, 0), new Coordinate2D(0.5, 0.5));

        assertEquals(sut.contains(a, b), true);
        assertEquals(a, a);
    }

    @Test
    public void testNotContains() {
        final Line2D a = new Line2D(new Coordinate2D(0, 0), new Coordinate2D(1, 1));
        final Line2D b = new Line2D(new Coordinate2D(0, 0), new Coordinate2D(-0.5, -0.5));

        assertEquals(sut.contains(a, b), false);
    }

    @Test
    public void testGetIntersectionWhenLinesIntersectAtOrigin() {
        // two lines with diff slopes that intersect at origin
        final Line2D a = new Line2D(new Coordinate2D(0, 0), new Coordinate2D(0, 1));
        final Line2D b = new Line2D(new Coordinate2D(0, 0), new Coordinate2D(-5, 0));

        assertEquals(sut.get_intersection(a, b).get(), new Coordinate2D(0, 0));
    }

    @Test
    public void testGetIntersectionWhenLinesIntersect() {
        final Line2D a = new Line2D(new Coordinate2D(0, 0), new Coordinate2D(0, 1));
        final Line2D b = new Line2D(new Coordinate2D(0, 1), new Coordinate2D(5, 1));

        assertEquals(sut.get_intersection(a, b).get(), new Coordinate2D(0, 1));
    }

    @Test
    public void testGetIntersectionWhenLinesParallel() {
        final Line2D a = new Line2D(new Coordinate2D(0, 0), new Coordinate2D(5, 0));
        final Line2D b = new Line2D(new Coordinate2D(0, 1), new Coordinate2D(5, 1));

        assertEquals(sut.get_intersection(a, b), Optional.empty());
    }
}
