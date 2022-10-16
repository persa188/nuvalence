package com.nuvalence.rectangles.types;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class BaseRectangleRequest {
    private final Rectangle rectangle_1;
    private final Rectangle rectangle_2;
}
