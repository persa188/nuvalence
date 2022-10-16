package com.nuvalence.rectangles.engine;

import com.nuvalence.rectangles.types.Coordinate2D;
import com.nuvalence.rectangles.types.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

public class TestRectangleComparisonEngineImpl {
    private final RectangleComparisonEngine sut = new RectangleComparisonEngineImpl(new LineComparisonEngineImpl());
    
    @Test
    public void testTwoRectanglesIntersect() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(1, 0.5),
                new Coordinate2D(2, 0.5),
                new Coordinate2D(1, -0.5),
                new Coordinate2D(2, -0.5)
        );

        List<Coordinate2D> expected = List.of(new Coordinate2D(1, 0), new Coordinate2D(2, 0));

        assertEquals(sut.intersects(a, b).get(), expected);
    }

    @Test
    public void testOverlappingRectanglesDoNotIntersect() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        assertEquals(sut.intersects(a, b), Optional.empty());
    }

    @Test
    public void testWhollyContainedRectanglesDoNotIntersect() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(0.5, 0.7),
                new Coordinate2D(1.5, 0.7),
                new Coordinate2D(0.5, 0.2),
                new Coordinate2D(1.5, 0.2)
        );

        assertEquals(sut.intersects(a, b), Optional.empty());
    }

    @Test
    public void testAdjacentRectanglesDoNotIntersect() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(-2, 1),
                new Coordinate2D(0, 1),
                new Coordinate2D(-2, 0),
                new Coordinate2D(0, 0.0)
        );

        assertEquals(sut.intersects(a, b), Optional.empty());
    }

    @Test
    public void testNonTouchingRectanglesDoNotIntersect() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(5, 3),
                new Coordinate2D(9, 3),
                new Coordinate2D(5, 0),
                new Coordinate2D(9, 0)
        );

        assertEquals(sut.intersects(a, b), Optional.empty());
    }

    @Test
    public void testWhollyContainsHappyPath() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(0.5, 0.7),
                new Coordinate2D(1.5, 0.7),
                new Coordinate2D(0.5, 0.2),
                new Coordinate2D(1.5, 0.2)
        );

        // Rectangle a contains Rectangle b
        assertEquals(sut.contains(a, b), true);

        // b contains a
        assertEquals(sut.contains(b, a), true);
    }

    @Test
    public void testContainsWhenNonTouchingRectanglesReturnsFalse() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(5, 3),
                new Coordinate2D(9, 3),
                new Coordinate2D(5, 0),
                new Coordinate2D(9, 0)
        );

        assertEquals(sut.contains(a, b), false);
    }

    @Test
    public void testContainsWithAdjacentRectanglesReturnsFalse() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(-2, 1),
                new Coordinate2D(0, 1),
                new Coordinate2D(-2, 0),
                new Coordinate2D(0, 0.0)
        );

        assertEquals(sut.contains(a, b), false);
    }

    @Test
    public void testContainsWithIntersectingRectanglesReturnsFalse() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(1, 0.5),
                new Coordinate2D(2, 0.5),
                new Coordinate2D(1, -0.5),
                new Coordinate2D(2, -0.5)
        );

        assertEquals(sut.contains(a, b), false);
    }

    @Test
    public void testIsAdjacentRectanglesProper() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(-2, 1),
                new Coordinate2D(0, 1),
                new Coordinate2D(-2, 0),
                new Coordinate2D(0, 0.0)
        );

        assertEquals(sut.isAdjacent(a, b), true);
    }

    @Test
    public void testIsAdjacentRectanglesSubLine() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 4),
                new Coordinate2D(3, 4),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        // right side will be adjacent sub-line (contained in the adjacent line)
        final Rectangle b = new Rectangle(
                new Coordinate2D(-5, 3),
                new Coordinate2D(0, 3),
                new Coordinate2D(-5, 1),
                new Coordinate2D(0, 1)
        );

        assertEquals(sut.isAdjacent(a, b), true);
    }

    @Test
    public void testIsAdjacentRectanglesPartial() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 4),
                new Coordinate2D(3, 4),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        // right side will be adjacent partial adjacent (as in instructions diagram)
        final Rectangle b = new Rectangle(
                new Coordinate2D(-5, 3),
                new Coordinate2D(0, 3),
                new Coordinate2D(-5, 1),
                new Coordinate2D(0, 0)
        );

        assertEquals(sut.isAdjacent(a, b), true);
    }

    @Test
    public void testIsAdjacentWhenRectanglesDoNotTouch() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        final Rectangle b = new Rectangle(
                new Coordinate2D(5, 3),
                new Coordinate2D(9, 3),
                new Coordinate2D(5, 0),
                new Coordinate2D(9, 0)
        );

        assertEquals(sut.isAdjacent(a, b), false);
    }

    @Test
    public void testIsAdjacentWhenRectanglesAreEqual() {
        final Rectangle a = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );
        final Rectangle b = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        // we would consider this an overlap case
        assertEquals(sut.isAdjacent(a, b), false);
    }
}
