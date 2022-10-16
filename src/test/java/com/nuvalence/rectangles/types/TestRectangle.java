package com.nuvalence.rectangles.types;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Due to time constraints this class will only test the happy path case for getLines().
 */
public class TestRectangle {

    @Test
    public void testGetLinesHappyPath() {
        Rectangle sut = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(2, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(2, 0)
        );

        List<Line2D> expected = List.of(
                new Line2D(new Coordinate2D(0, 1), new Coordinate2D(2, 1)), // top
                new Line2D(new Coordinate2D(0, 1), new Coordinate2D(0, 0)), // left
                new Line2D(new Coordinate2D(2, 1), new Coordinate2D(2, 0)), // right
                new Line2D(new Coordinate2D(0, 0), new Coordinate2D(2, 0))  // bottom
        );

        List<Line2D> lines = sut.getLines();

        assertEquals(expected, lines);
    }
}
