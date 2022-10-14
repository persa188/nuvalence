package com.nuvalence.rectangles.types;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
public class Rectangle {
    @Getter
    private final Coordinate2D topLeft;
    @Getter
    private final Coordinate2D topRight;
    @Getter
    private final Coordinate2D bottomLeft;
    @Getter
    private final Coordinate2D bottomRight;


    public List<Line2D> getLines() {
        List<Line2D> lines = Arrays.asList(
                // top
                new Line2D(topLeft, topRight),
                // left
                new Line2D(topLeft, bottomLeft),
                // right
                new Line2D(topRight, bottomRight),
                //bottom
                new Line2D(bottomLeft, bottomRight)
        );

        return lines;
    }

    @Override
    public String toString() {
        return String.format("topLeft: %s, topRight: %s, bottomLeft: %s, bottomRight: %s", topLeft, topRight, bottomLeft, bottomRight);
    }

}
