package com.nuvalence.rectangles.config;

import com.nuvalence.rectangles.engine.LineComparisonEngine;
import com.nuvalence.rectangles.engine.LineComparisonEngineImpl;
import com.nuvalence.rectangles.engine.RectangleComparisonEngine;
import com.nuvalence.rectangles.engine.RectangleComparisonEngineImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RectangleComparisonEngine rectangleEngine() {
        return new RectangleComparisonEngineImpl(new LineComparisonEngineImpl());
    }
}
