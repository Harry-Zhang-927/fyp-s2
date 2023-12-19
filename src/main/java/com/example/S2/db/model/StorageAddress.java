package com.example.S2.db.model;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@TableName(value = "storage_address")
public class StorageAddress {

    private String uuid;

    private String tankId;

    private String tag;

    private String url;

    private LocalDateTime date;

    private String state;

    // Getters and Setters
    // ...
}
