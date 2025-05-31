package com.cosmos.assignment.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/health")
@RestController
public class HealthCheckController {

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ResponseEntity<Map<String, String>> healtCheck() {
        Map<String, String> result = new HashMap<>();
        result.put("Status", "Running");
        result.put("Time", new Date().toString());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
