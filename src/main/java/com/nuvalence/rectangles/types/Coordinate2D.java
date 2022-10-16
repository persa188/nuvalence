package com.nuvalence.rectangles.types;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
/**
 * A class that represents a point / coordinate on a 2-Dimensional Grid.
 */
public class Coordinate2D {
    private final double x;
    private final double y;

    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
