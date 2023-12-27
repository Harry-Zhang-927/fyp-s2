package com.example.S2.controller;

import com.example.S2.db.model.StorageAddress;
import com.example.S2.model.BlockProcessingVO;
import com.example.S2.service.impl.StorageAddressServiceImpl;
import com.example.S2.utils.DataBlockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class DataController {
    @Autowired
    StorageAddressServiceImpl storageAddressService;
    public static final String outputCsvPath = "/Users/zhanghaoran/Desktop/FYP/data/data5/1/trf1.csv_tagged.csv";

    @PostMapping("/search")
    public String search(@RequestBody String tag) throws IOException {
        return storageAddressService.getBlockMD5ByAddress(tag);
    }

    @PostMapping("/store")
    public ResponseEntity<Boolean> store(@RequestBody BlockProcessingVO blockProcessingVO) throws IOException {
        List<String> tags = blockProcessingVO.getSignatures();
        String tankId = "1";
        String url = "/Users/zhanghaoran/Desktop/FYP/S2_storage/" + tankId + "/" + UUID.randomUUID() + ".csv";
        String state = "1";
        saveTags(tags, tankId, url, state);

        DataBlockUtil.writeToCSV(blockProcessingVO.getCsv(), url);

        return ResponseEntity.ok(true);
    }

    public void saveTags(List<String> tags, String tankId, String url, String state) throws IOException {
        List<StorageAddress> storageAddresses = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        for (String tag : tags) {
            StorageAddress storageAddress = new StorageAddress();
            storageAddress.setUuid(UUID.randomUUID().toString());
            storageAddress.setTankId(tankId);
            storageAddress.setTag(tag);
            storageAddress.setUrl(url);
            storageAddress.setDate(now);
            storageAddress.setState(state);
            storageAddresses.add(storageAddress);
        }

        storageAddressService.storeSignatures(storageAddresses);
    }
}
