package com.example.S2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class DataController {
    @PostMapping("/store")
    public boolean store(@RequestBody byte[] data) throws InterruptedException {
        Thread.sleep(1000);
        return true;
    }
}
