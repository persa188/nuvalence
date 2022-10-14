package com.nuvalence.rectangles.engine;

import com.nuvalence.rectangles.types.Coordinate2D;
import com.nuvalence.rectangles.types.Line2D;

import java.util.Optional;

public interface LineComparisonEngine {
    boolean isParallel(Line2D a, Line2D b);

    boolean contains(Line2D a, Line2D b);

    Optional<Coordinate2D> get_intersection(Line2D a, Line2D b);
}
