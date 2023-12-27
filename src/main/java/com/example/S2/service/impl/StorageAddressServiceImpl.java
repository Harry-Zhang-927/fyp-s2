package com.example.S2.service.impl;
//import com.example.S2.db.mapper.StorageAddressMapper;
//import com.example.S2.db.mapper.StorageAddressMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.S2.db.mapper.StorageAddressMapper;
import com.example.S2.db.model.StorageAddress;
import com.example.S2.service.StorageAddressService;
import com.example.S2.utils.DataBlockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StorageAddressServiceImpl extends ServiceImpl<StorageAddressMapper,StorageAddress> implements StorageAddressService {
    @Autowired
    private StorageAddressMapper storageAddressMapper;

    public StorageAddress getStorageAddressesByTag(String tag) {
        return storageAddressMapper.findStorageAddressByTag(tag);
    }

    public String getBlockMD5ByAddress(String tag) throws IOException {
        StorageAddress storageAddress = getStorageAddressesByTag(tag);
        return DataBlockUtil.findAndRemoveBlockWithSignatureSequential(storageAddress.getUrl(), 1000, tag);
    }

    public void storeSignatures(List<StorageAddress> storageAddresses) {
        this.saveBatch(storageAddresses);
    }
}
