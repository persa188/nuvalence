package com.nuvalence.rectangles.engine;

import com.nuvalence.rectangles.types.Coordinate2D;
import com.nuvalence.rectangles.types.Rectangle;

import java.util.List;
import java.util.Optional;

public interface RectangleComparisonEngine {
    /**
     * @param a A rectangle.
     * @param b A rectangle.
     * @return An optional list of coordinates where rectangle a and b intersect.
     */
    public Optional<List<Coordinate2D>> intersects(Rectangle a, Rectangle b);

    /**
     * @param a A rectangle.
     * @param b A rectangle.
     * @return True iff rectangle a contains rectangle b or rectangle b contains rectangle a.
     */
    public boolean contains(Rectangle a, Rectangle b);

    /**
     * @param a A rectangle.
     * @param b A rectangle.
     * @return True iff rectangle a is adjacent to rectangle b.
     */
    public boolean isAdjacent(Rectangle a, Rectangle b);
}
