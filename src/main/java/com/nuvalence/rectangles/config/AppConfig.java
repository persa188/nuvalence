package com.nuvalence.rectangles.config;

import com.nuvalence.rectangles.engine.LineComparisonEngineImpl;
import com.nuvalence.rectangles.engine.RectangleComparisonEngine;
import com.nuvalence.rectangles.engine.RectangleComparisonEngineImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RectangleComparisonEngine rectangleEngine() {
        // this could probably be replaced with a factory if
        // we ever had a ton of implementations - opted to just keep it simple here and return
        // the concrete impl.
        return new RectangleComparisonEngineImpl(new LineComparisonEngineImpl());
    }
}
