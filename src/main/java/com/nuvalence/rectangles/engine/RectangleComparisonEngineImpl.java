package com.nuvalence.rectangles.engine;

import com.nuvalence.rectangles.types.Coordinate2D;
import com.nuvalence.rectangles.types.Line2D;
import com.nuvalence.rectangles.types.Rectangle;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class RectangleComparisonEngineImpl implements RectangleComparisonEngine {
    private final LineComparisonEngine lineEngine;


    private boolean strictContains(Rectangle a, Rectangle b) {
        if (
                a.getTopLeft().getX() >= b.getTopLeft().getX() && a.getTopLeft().getY() <= b.getTopLeft().getY()
                        && a.getBottomLeft().getX() >= b.getBottomLeft().getX() && a.getBottomLeft().getY() >= b.getBottomLeft().getY()
                        && a.getTopRight().getX() <= b.getTopRight().getX() && a.getTopRight().getY() <= b.getTopRight().getY()
                        && a.getBottomRight().getX() <= b.getBottomRight().getX() && a.getBottomRight().getY() >= b.getBottomRight().getY()
        ) {
            return true;
        }
        return false;
    }
    @Override
    public boolean contains(Rectangle a, Rectangle b) {
        return strictContains(a, b) || strictContains(b, a);
    }

    @Override
    public Optional<List<Coordinate2D>> intersects(Rectangle a, Rectangle b) {
        // we don't want to consider these intersecting
        if (contains(a, b) || isAdjacent(a, b)) {
            return Optional.empty();
        }

        List<Coordinate2D> intersection_points = new ArrayList<>();

        for (Line2D line: a.getLines()) {
            for (Line2D otherLine: b.getLines()) {
                Optional<Coordinate2D> intersect = lineEngine.get_intersection(line, otherLine);

                if (intersect.isPresent()) {
                    intersection_points.add(intersect.get());
                }
            }
        }

        return intersection_points.isEmpty() ? Optional.empty() : Optional.of(intersection_points);
    }
    @Override
    public boolean isAdjacent(Rectangle a, Rectangle b) {
        // covers the edge case if a == b
        if (contains(a, b)) {
            return false;
        }

        int numOverlap = 0;

        for (Line2D line: a.getLines()) {
            for (Line2D otherLine: b.getLines()) {
                if (lineEngine.contains(line, otherLine)) {
                    numOverlap++;
                }
            }
        }

        return numOverlap == 1;
    }
}
