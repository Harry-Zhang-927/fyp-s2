package com.example.S2.db.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.S2.db.model.StorageAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StorageAddressMapper extends BaseMapper<StorageAddress> {

    default StorageAddress findStorageAddressByTag(String tag) {
        // 使用 MyBatis Plus 提供的 QueryWrapper 来构造查询条件
        return selectOne(new QueryWrapper<StorageAddress>().eq("tag", tag));
    }

}
