package com.example.S2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlockProcessingVO {
    List<String> signatures;
    List<String> csv;
    byte[] csvBin;
    Boolean storedSuccessfully;
}
