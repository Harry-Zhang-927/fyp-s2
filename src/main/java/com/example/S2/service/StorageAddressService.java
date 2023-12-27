package com.example.S2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.S2.db.model.StorageAddress;
import org.springframework.stereotype.Service;

import java.io.IOException;

//纳入spring容器管理
@Service
public interface StorageAddressService extends IService<StorageAddress> {
    StorageAddress getStorageAddressesByTag(String tag);

    String getBlockMD5ByAddress(String tag) throws IOException;


}
