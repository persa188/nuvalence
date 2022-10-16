package com.nuvalence.rectangles.controller;

import com.nuvalence.rectangles.types.BaseRectangleRequest;
import com.nuvalence.rectangles.types.Coordinate2D;
import com.nuvalence.rectangles.types.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
/**
 * This class is a unit test that acts like a smoke test (since no time for integration tests).
 */
public class TestRectanglesController {
    @Autowired
    private RectanglesController controller;

    private Rectangle rectangle_1;
    private Rectangle rectangle_2;

    @Mock
    private BaseRectangleRequest mockRequest;

    @BeforeEach
    public void setUp() {
        rectangle_1 = new Rectangle(
                new Coordinate2D(0, 1),
                new Coordinate2D(3, 1),
                new Coordinate2D(0, 0),
                new Coordinate2D(3, 0)
        );

        rectangle_2 = new Rectangle(
                new Coordinate2D(1, 0.5),
                new Coordinate2D(2, 0.5),
                new Coordinate2D(1, -0.5),
                new Coordinate2D(2, -0.5)
        );

    }

    @Test
    public void intersectControllerWhenValidInputReturnsResponse() {
        // just assert that valid response properly bubbles up
        assertEquals(
                controller.intersectController(new BaseRectangleRequest(rectangle_1, rectangle_2)),
                List.of(new Coordinate2D(1, 0), new Coordinate2D(2, 0)));
    }

    @Test
    public void adjacencyControllerWhenValidInputReturnsResponse() {
        // just assert that valid response properly bubbles up
        assertEquals(
                controller.adjacencyController(new BaseRectangleRequest(rectangle_1, rectangle_2)),
                 false);
    }

    @Test
    public void containsControllerWhenValidInputReturnsResponse() {
        // just assert that valid response properly bubbles up
        assertEquals(
                controller.containsController(new BaseRectangleRequest(rectangle_1, rectangle_2)),
                false);
    }

    @Test
    public void allControllerAPIsWhenOneRectangleReturnsException() {
        // just assert that valid response properly bubbles up
        when(mockRequest.getRectangle_1()).thenReturn(rectangle_1);
        when(mockRequest.getRectangle_2()).thenReturn(null);

        // we should be testing a more specific exception, not doing
        // due to time constraints
        // a integration test would've been better for this case so we can test a status 500 res.
        assertThrows(Exception.class,
                () -> controller.intersectController(mockRequest)
        );
        assertThrows(Exception.class,
                () -> controller.adjacencyController(mockRequest)
        );
        assertThrows(Exception.class,
                () -> controller.containsController(mockRequest)
        );
    }

    @Test
    public void allControllerAPIsWhenNoRectanglesReturnsException() {
        // just assert that valid response properly bubbles up
        when(mockRequest.getRectangle_1()).thenReturn(null);
        when(mockRequest.getRectangle_2()).thenReturn(null);

        // we should be testing a more specific exception, not doing
        // due to time constraints
        // a integration test would've been better for this case so we can test a status 500 res.
        assertThrows(Exception.class,
                () -> controller.intersectController(mockRequest)
        );
        assertThrows(Exception.class,
                () -> controller.adjacencyController(mockRequest)
        );
        assertThrows(Exception.class,
                () -> controller.containsController(mockRequest)
        );
    }

}
