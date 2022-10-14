package com.nuvalence.rectangles.controller;
import com.nuvalence.rectangles.engine.RectangleComparisonEngine;
import com.nuvalence.rectangles.types.Coordinate2D;
import com.nuvalence.rectangles.types.BaseRectangleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RectanglesController {
    @Autowired
    private RectangleComparisonEngine rectangleEngine;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/api/rectangles/intersects")
    public List<Coordinate2D> intersectController(
            @RequestBody BaseRectangleRequest request
            ) {
        return rectangleEngine.intersects(request.getRectangle_1(), request.getRectangle_2()).orElse(Arrays.asList());
    }

    @PostMapping("/api/rectangles/contains")
    public boolean containsController(
            @RequestBody BaseRectangleRequest request
    ) {
        return rectangleEngine.contains(request.getRectangle_1(), request.getRectangle_2());
    }

    @PostMapping("/api/rectangles/isAdjacent")
    public boolean adjacencyController(
            @RequestBody BaseRectangleRequest request
    ) {
        return rectangleEngine.isAdjacent(request.getRectangle_1(), request.getRectangle_2());
    }
}