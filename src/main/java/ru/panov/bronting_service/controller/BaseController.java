package ru.panov.bronting_service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/start")
@RestController
public class BaseController {

    @GetMapping
    public String getStartPage () {
        return "<h1>Start page<h1/>";
    }
}
