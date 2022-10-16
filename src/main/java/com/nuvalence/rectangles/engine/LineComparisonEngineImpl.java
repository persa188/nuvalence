package com.nuvalence.rectangles.engine;

import com.nuvalence.rectangles.types.Coordinate2D;
import com.nuvalence.rectangles.types.Line2D;

import java.util.Optional;

public class LineComparisonEngineImpl implements LineComparisonEngine {
    public boolean isParallel(Line2D a, Line2D b) {
        return a.getSlope() == b.getSlope();
    }

    public boolean contains(Line2D a, Line2D b) {
        return isParallel(a, b)
                && (inBounds(a, b.getCoord1()) && inBounds(a, b.getCoord2()));
    }

    private boolean inBounds(Line2D a, Coordinate2D coord) {
        double topBound = Math.max(a.getCoord1().getY(), a.getCoord2().getY());
        double bottomBound = Math.min(a.getCoord1().getY(), a.getCoord2().getY());
        double leftBound = Math.min(a.getCoord1().getX(), a.getCoord2().getX());
        double rightBound = Math.max(a.getCoord1().getX(), a.getCoord2().getX());

        return coord.getY() <= topBound && coord.getY() >= bottomBound
                && coord.getX() >= leftBound && coord.getX() <= rightBound;
    }

    public Optional<Coordinate2D> get_intersection(Line2D a, Line2D b) {
        // credits to https://stackoverflow.com/questions/16314069/calculation-of-intersections-between-line-segments
        // Line AB represented as a1x + b1y = c1
        double determinant = a.getA()*b.getB() - b.getA()*a.getB();

        if (determinant == 0) {
            return Optional.empty();
        }

        double x = (b.getB()*a.getC() - a.getB()*b.getC())/determinant;
        double y = (a.getA()*b.getC() - b.getA()*a.getC())/determinant;

        if (x == -0.0) {
            x = Math.abs(x);
        }
        if (y == -0.0) {
            y = Math.abs(y);
        }

        Coordinate2D coord = new Coordinate2D(x, y);

        if (inBounds(a, coord) && inBounds(b, coord)) {
            return Optional.of(coord);
        }

        return Optional.empty();
    }
}
