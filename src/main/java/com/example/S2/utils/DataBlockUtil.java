package com.example.S2.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DataBlockUtil {

    public static String findAndRemoveBlockWithSignatureSequential(String csvPath, int rowsPerBlock, String signatureToFind) throws IOException {
        long startTime = System.currentTimeMillis();
        Path path = Paths.get(csvPath);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            int lineCount = 0;
            List<String> currentBlock = new ArrayList<>();

            // 跳过表头
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                currentBlock.add(line);
                lineCount++;

                // 检查是否达到了数据块的结束，或者是否是文件的最后一行
                if (lineCount % (rowsPerBlock + 1) == 0 || !reader.ready()) {
                    // 搜索当前数据块中的MD5值
                    Optional<String> foundLine = currentBlock.stream()
                            .filter(l -> l.contains(signatureToFind))
                            .findFirst();

                    if (foundLine.isPresent()) {
                        // 从数据块中移除包含MD5的行
                        currentBlock.remove(foundLine.get());
                        String remainingBlock = String.join("\n", currentBlock);
                        long endTime = System.currentTimeMillis(); // 结束时间
                        System.out.println("Time taken: " + (endTime - startTime) + " ms"); // 打印所花时间
                        return MD5Util.calculateMD5(remainingBlock);
                    } else {
                        // 没有发现MD5，重置当前数据块以读取下一个数据块
                        currentBlock.clear();
                        lineCount = 0;
                    }
                }
            }
            System.out.println("MD5 " + signatureToFind + " not found in any block.");
            return  "hehe";
        }
    }

    public static void writeToCSV(List<String> data, String filename) throws IOException {
        Path path = Paths.get(filename);

        // 确保父目录存在
        if (path.getParent() != null && !Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }

        // 使用 try-with-resources 语句来自动关闭 PrintWriter
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path))) {
            // 遍历数据列表，写入每个字符串
            for (String str : data) {
                writer.println(str);
            }
        }
    }
}

