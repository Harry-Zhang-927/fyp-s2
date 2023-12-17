package com.example.S2.controller;

import com.example.S2.utils.DataBlockUtil;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class DataController {
    public static final String outputCsvPath = "/Users/zhanghaoran/Desktop/FYP/data/data5/1/trf1.csv_tagged.csv";

    @PostMapping("/search")
    public String search(@RequestBody String tag) throws InterruptedException, IOException {
        return DataBlockUtil.findAndRemoveBlockWithSignatureSequential(outputCsvPath, 1000, tag);
    }
}
