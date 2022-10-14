package com.nuvalence.rectangles.types;

import lombok.Data;

import java.util.Optional;

@Data
public class Line2D {
    private final Coordinate2D coord1;
    private final Coordinate2D coord2;
    private final double slope;
    private final double intercept;
    private final double A;
    private final double B;
    private final double C;

    public Line2D(Coordinate2D coord1, Coordinate2D coord2) {
        this.coord1 = coord1;
        this.coord2 = coord2;

        // for standard form of line = Ax + By - C = 0
        this.slope = (coord1.getY() - coord2.getY()) / (coord1.getX() - coord2.getX());
        // from the equation y = mx + b, we get  mx - y = 0
        // where b is the y-intercept
        intercept = coord1.getY() - (slope * coord1.getX());

        A = this.coord2.getY() - this.coord1.getY();
        B = this.coord1.getX() - this.coord2.getX();
        C = this.coord1.getX() * A + coord1.getY()*(B);
    }
}
