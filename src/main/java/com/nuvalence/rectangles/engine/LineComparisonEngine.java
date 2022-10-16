package com.nuvalence.rectangles.engine;

import com.nuvalence.rectangles.types.Coordinate2D;
import com.nuvalence.rectangles.types.Line2D;

import java.util.Optional;

public interface LineComparisonEngine {
    /**
     * @param a 2D Line that can be plotted on a grid.
     * @param b 2D Line that can be plotted on a grid.
     * @return True iff line a runs parallel to line b on a 2D grid. This will return true
     * if the lines are the same or overlap.
     */
    boolean isParallel(Line2D a, Line2D b);

    /**
     * @param a 2D Line that can be plotted on a grid.
     * @param b 2D Line that can be plotted on a grid.
     * @return True iff a contains b, False otherwise.
     */
    boolean contains(Line2D a, Line2D b);

    /**
     * @param a 2D Line that can be plotted on a grid.
     * @param b 2D Line that can be plotted on a grid.
     * @return A coordinate where the two lines intersect, Optional.Empty() otherwise.
     *         Parallel lines (even when overlapping) will not be considered intersecting.
     */
    Optional<Coordinate2D> get_intersection(Line2D a, Line2D b);
}
