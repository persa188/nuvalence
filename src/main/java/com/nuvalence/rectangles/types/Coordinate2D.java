package com.nuvalence.rectangles.types;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Coordinate2D {
    private double x;
    private double y;

    public Coordinate2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
