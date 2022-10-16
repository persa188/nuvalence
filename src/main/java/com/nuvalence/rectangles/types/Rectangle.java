package com.nuvalence.rectangles.types;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
/**
 * A class that represents a rectangle on a 2-Dimensional Grid.
 */
public class Rectangle {
    private final Coordinate2D topLeft;
    private final Coordinate2D topRight;
    private final Coordinate2D bottomLeft;
    private final Coordinate2D bottomRight;


    public List<Line2D> getLines() {
       return Arrays.asList(
                // top
                new Line2D(topLeft, topRight),
                // left
                new Line2D(topLeft, bottomLeft),
                // right
                new Line2D(topRight, bottomRight),
                //bottom
                new Line2D(bottomLeft, bottomRight)
        );
    }

    @Override
    public String toString() {
        return String.format("topLeft: %s, topRight: %s, bottomLeft: %s, bottomRight: %s", topLeft, topRight, bottomLeft, bottomRight);
    }

}
