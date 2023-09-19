package org.example;

import java.util.HashMap;

public class DotP {
    // 计算点积
    public static double dotProduct(HashMap<String, int[]> wordMap) {
        double res = 0;
        for (int[] c : wordMap.values()) {
            res += (c[0] * c[1]);
        }
        return res;
    }
}
