package com.cq.example.test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/11 13:27
 * @Description:
 */
@Slf4j
public class FilesTest {
    public static void main(String[] args) {
        try {
            List<String> list=Files.readLines(new File("E://134.xlsx"), Charsets.ISO_8859_1);
            for(String s : list) {
                log.info("数据为{}",s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
