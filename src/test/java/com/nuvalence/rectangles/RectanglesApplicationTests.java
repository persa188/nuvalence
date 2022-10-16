package com.nuvalence.rectangles;

import com.nuvalence.rectangles.controller.RectanglesController;
import com.nuvalence.rectangles.engine.RectangleComparisonEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RectanglesApplicationTests {
	@Autowired
	private RectanglesController controller;
	@Autowired
	private RectangleComparisonEngine rectangleEngine;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(rectangleEngine).isNotNull();
	}

}
