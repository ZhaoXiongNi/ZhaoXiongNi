package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Content {
    public static void getContent(String filePath, StringBuffer content) {
        BufferedReader fileReader;
        if(!new File(filePath).exists()){
            System.out.println("文件路径  "+filePath+"  不存在");   //文件不存在报错
        }
        try {
            fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)); //文件内容读取器
            String firstLine;
            // 首先检查文件是否为空
            if ((firstLine = fileReader.readLine()) == null) {
                System.out.println("文件路径  "+filePath+"  为空");
                return;
            }
            content.append(firstLine);

            while (null != fileReader.readLine()){
                content.append(fileReader.readLine());   //获取文件内容
            }
            fileReader.close();    //关闭读取器
        }catch (Exception e){
            System.out.println("读取失败");
        }
    }
}
