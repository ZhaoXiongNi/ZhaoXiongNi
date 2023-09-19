package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        /*
        从命令行获取文件路径
         */
        String filePath1 = args[0];     //抄袭文件1路径
        String filePath2 = args[1];     //抄袭文件2路径
        String outputPath3 = args[2];   //输出相似率路径

        /*
        读取文件内容
         */
        BufferedReader fileReader1 = new BufferedReader(new FileReader(filePath1)); //文件1内容读取器
        BufferedReader fileReader2 = new BufferedReader(new FileReader(filePath2)); //文件2内容读取器
        String content1 = fileReader1.readLine();   //获取文件1内容
        String content2 = fileReader2.readLine();   //获取文件2内容
        fileReader1.close();    //关闭读取器
        fileReader2.close();    //关闭读取器


    }
}