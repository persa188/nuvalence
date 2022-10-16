package com.nuvalence.rectangles.types;

import lombok.Data;

@Data
/**
 * A simple class that represents a 2-Dimensional line between two points on a Grid.
 */
public class Line2D {
    private final Coordinate2D coord1;
    private final Coordinate2D coord2;
    private final double slope;
    private final double intercept;
    private final double A;
    private final double B;
    private final double C;

    public Line2D(Coordinate2D coord1, Coordinate2D coord2) {
        // Store the coordinate info
        this.coord1 = coord1;
        this.coord2 = coord2;

        // get info for slope-intercept form of the line
        // for the equation y = mx + b
        this.slope = (coord1.getY() - coord2.getY()) / (coord1.getX() - coord2.getX());
        // solving y = mx + b for the y-intercept,
        // where b is the y-intercept
        intercept = coord1.getY() - (slope * coord1.getX());

        // A, B, C here are for standard form of a line eqn Ax + By = C
        // This is useful for the line intersection formula
        A = this.coord2.getY() - this.coord1.getY();
        B = this.coord1.getX() - this.coord2.getX();
        C = this.coord1.getX() * A + coord1.getY()*(B);
    }
}
