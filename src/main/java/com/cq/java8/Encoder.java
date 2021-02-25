package com.cq.java8;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Base64;

/**
 * @author caoqiang
 * @date 2020/4/30下午3:34
 */
@Slf4j
public class Encoder {
    static final Base64.Decoder decoder = Base64.getDecoder();
    static final Base64.Encoder encoder = Base64.getEncoder();

    public static void main(String[] args) {

        String text ="天涯的尽头是风沙\n" +
                "红尘的故事叫牵挂\n" +
                "封刀隐没在寻常人家东篱下\n" +
                "闲云野鹤古刹\n" +
                "快马在江湖里厮杀\n" +
                "无非是名跟利放不下\n" +
                "心中有江山的人岂能快意潇洒\n" +
                "我只求与你共华发\n" +
                "剑出鞘恩怨了谁笑\n" +
                "我只求今朝拥你入怀抱\n" +
                "红尘客栈风似刀\n" +
                "骤雨落宿命敲\n" +
                "任武林谁领风骚\n" +
                "我却只为你折腰\n" +
                "过荒村野桥寻世外古道\n" +
                "远离人间尘嚣\n" +
                "柳絮飘执指之手逍遥\n" +
                "檐下窗棂斜映枝桠\n" +
                "与你席地对座饮茶\n" +
                "我以工笔画将你牢牢的记下\n" +
                "提笔不为风雅\n" +
                "等下叹红颜近晚霞\n" +
                "我说缘分一如参禅不说话\n" +
                "你泪如梨花洒满了纸上的天下\n" +
                "爱恨如写意山水画\n" +
                "剑出鞘恩怨了谁笑\n" +
                "我只求今朝拥你入怀抱\n" +
                "完\n" +
                "天涯的尽头是风沙\n" +
                "红尘的故事叫牵挂\n" +
                "封刀隐没在寻常人家东篱下\n" +
                "闲云野鹤古刹\n" +
                "快马在江湖里厮杀\n" +
                "无非是名跟利放不下\n" +
                "心中有江山的人岂能快意潇洒\n" +
                "我只求与你共华发\n" +
                "剑出鞘恩怨了谁笑\n" +
                "我只求今朝拥你入怀抱\n" +
                "红尘客栈风似刀\n" +
                "骤雨落宿命敲\n" +
                "任武林谁领风骚\n" +
                "我却只为你折腰\n" +
                "过荒村野桥寻世外古道\n" +
                "远离人间尘嚣\n" +
                "柳絮飘执指之手逍遥\n" +
                "檐下窗棂斜映枝桠\n" +
                "与你席地对座饮茶\n" +
                "我以工笔画将你牢牢的记下\n" +
                "提笔不为风雅\n" +
                "等下叹红颜近晚霞\n" +
                "我说缘分一如参禅不说话\n" +
                "你泪如梨花洒满了纸上的天下\n" +
                "爱恨如写意山水画\n" +
                "剑出鞘恩怨了谁笑\n" +
                "我只求今朝拥你入怀抱\n" +
                "完\n" +
                "天涯的尽头是风沙\n" +
                "红尘的故事叫牵挂\n" +
                "封刀隐没在寻常人家东篱下\n" +
                "闲云野鹤古刹\n" +
                "快马在江湖里厮杀\n" +
                "无非是名跟利放不下\n" +
                "心中有江山的人岂能快意潇洒\n" +
                "我只求与你共华发\n" +
                "剑出鞘恩怨了谁笑\n" +
                "我只求今朝拥你入怀抱\n" +
                "红尘客栈风似刀\n" +
                "骤雨落宿命敲\n" +
                "任武林谁领风骚\n" +
                "我却只为你折腰\n" +
                "过荒村野桥寻世外古道\n" +
                "远离人间尘嚣\n" +
                "柳絮飘执指之手逍遥\n" +
                "檐下窗棂斜映枝桠\n" +
                "与你席地对座饮茶\n" +
                "我以工笔画将你牢牢的记下\n" +
                "提笔不为风雅\n" +
                "等下叹红颜近晚霞\n" +
                "我说缘分一如参禅不说话\n" +
                "你泪如梨花洒满了纸上的天下\n" +
                "爱恨如写意山水画\n" +
                "剑出鞘恩怨了谁笑\n" +
                "我只求今朝拥你入怀抱\n" +
                "完";
//        String encodeText = encode(text);
//        System.out.println(encodeText);
//        System.out.println(decoder(encodeText));
//        if ("1".equals(null)) {
//            System.out.println(1);
//        } else {
//            System.out.println(2);
//
//        }
        Long l= 100L;

        String ss = new BigDecimal(l).divide(new BigDecimal(100)).toString();

        double mm = Math.ceil(l / 100.0);

        //Long ss = Double.doubleToLongBits(mm);
        System.out.println(ss);


    }

    private static void readFile() {
        try {
            String filePath = "D:/aa.txt";
            FileInputStream fin = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            String strTmp = "";
            while((strTmp = buffReader.readLine())!=null){
                System.out.println(strTmp);
            }
            buffReader.close();
        } catch (Exception e) {

        }
    }



    private static String encode(String text) {
        String encodedText = null;
        try {
            byte[] textByte = text.getBytes("UTF-8");
            encodedText = encoder.encodeToString(textByte);
        } catch (Exception e) {
            log.error("base64编码异常");
        }
       return encodedText;
    }

    private static String decoder(String encodedText) {
        try {
            byte [] bytes = decoder.decode(encodedText);
            return new String(bytes, "UTF-8");
        } catch (Exception e) {
            log.error("base64解码异常");
        }
        return null;
    }
}
