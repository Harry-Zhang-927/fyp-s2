package com.example.S2.controller;

import com.example.S2.service.impl.StorageAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class DataController {
    @Autowired
    StorageAddressServiceImpl storageAddressService;
    public static final String outputCsvPath = "/Users/zhanghaoran/Desktop/FYP/data/data5/1/trf1.csv_tagged.csv";

    @PostMapping("/search")
    public String search(@RequestBody String tag) throws IOException {
        return storageAddressService.getBlockMD5ByAddress(tag);
    }
}
