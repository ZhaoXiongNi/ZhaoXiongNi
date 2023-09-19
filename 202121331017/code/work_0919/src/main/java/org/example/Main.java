/**
 * 主题：工程概论第二次作业——查重
 * 作者：倪肇雄
 * 时间：2023-09-19
 * 联系方式：zhaoxiong.ni@qq.com
 * 请勿抄袭
 */
package org.example;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.io.*;
import java.util.HashMap;
import java.util.List;

import static org.example.Content.getContent;
import static org.example.DotP.dotProduct;

public class Main {
    public static void main(String[] args) throws Exception{
        //从命令行获取文件路径
        String filePath1 = args[0];     //抄袭文件1的路径
        String filePath2 = args[1];     //抄袭文件2的路径
        String outputPath = args[2];   //输出相似率路径


        //读取文件内容
        //创建文章结果
        StringBuffer content1 = new StringBuffer();
        StringBuffer content2 = new StringBuffer();

        //调用自定义函数读取文件中的文字
        getContent(filePath1, content1);
        getContent(filePath2, content2);
        //System.out.println(content1+"*"+content2);    临时测试代码

        //使用HanLP分词器进行分词,Term对象代表句子中的一个词
        List<Term> fileWords1 = HanLP.segment(content1.toString().trim());    //词语集1，文件1的内容,去除空格
        List<Term> fileWords2 = HanLP.segment(content2.toString().trim());    //词语集2，文件2的内容,去除空格

        //创建HashMap存储词频向量，我在使用二维数组作为value统计两个文件中的值
        HashMap<String, int[]> wordMap = new HashMap<>();
        int[] tmp;

        //遍历词语集中的词，计数
        for (Term term : fileWords1) {
            //该词重复，计数
            if (wordMap.containsKey(term.word)) {
                wordMap.get(term.word)[0]++;
            } else {
                //该词不存在，创建新key进行计数
                tmp = new int[2];
                tmp[0] = 1;
                wordMap.put(term.word, tmp);
            }
        }

        //跟上述同样的方法，提取第二个文件的内容，区别为此时对value数组中的第二个数据进行操作
        for (Term term : fileWords2) {
            if (wordMap.containsKey(term.word)) {
                wordMap.get(term.word)[1]++;
            } else {
                tmp = new int[2];
                tmp[1] = 1;
                wordMap.put(term.word, tmp);
            }
        }
        //计算余弦相似度算法的二者平方根之和
        double[] sqrtSums = SSR.sumOfSquareRoots(wordMap);
        //计算余弦相似度
        double res = dotProduct(wordMap) / (sqrtSums[0]*sqrtSums[1]);

        // 将结果写入输出文件，计算出的值为范围在0~1之间的余弦相似度，需要*100才是相似率
        try (PrintWriter out = new PrintWriter(outputPath)) {
            out.printf("%.2f%%", res*100);    //输出为浮点型的保留两位小数
        }

        //终端输出测试答案,计算出的值为范围在0~1之间的余弦相似度，需要*100才是相似率
        System.out.printf("相似率：%.2f %%, 结果成功已转存到文件中\n",res*100);
    }






}