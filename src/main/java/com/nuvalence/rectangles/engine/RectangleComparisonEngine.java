package com.nuvalence.rectangles.engine;

import com.nuvalence.rectangles.types.Coordinate2D;
import com.nuvalence.rectangles.types.Rectangle;

import java.util.List;
import java.util.Optional;

public interface RectangleComparisonEngine {
    public Optional<List<Coordinate2D>> intersects(Rectangle a, Rectangle b);

    public boolean contains(Rectangle a, Rectangle b);

    public boolean isAdjacent(Rectangle a, Rectangle b);
}
