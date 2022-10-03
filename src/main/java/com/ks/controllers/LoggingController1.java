package com.ks.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "kitchenstory/ping")
public class LoggingController1 {

    Logger logger = LoggerFactory.getLogger(LoggingController1.class);

   @RequestMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "......Howdy! Kitchen Story Backedn App is Alive and Kicking.....";
    }
}