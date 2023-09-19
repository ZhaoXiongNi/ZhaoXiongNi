package org.example;

import java.util.HashMap;

public class SSR {
    // 计算二者平方根之和
    public static double[] sumOfSquareRoots(HashMap<String, int[]> wordMap) {
        double[] res = new double[2];
        for (int[] c : wordMap.values()) {
            res[0] += (c[0] * c[0]);
            res[1] += (c[1] * c[1]);
        }
        res[0] = Math.sqrt(res[0]);
        res[1] = Math.sqrt(res[1]);

        return res;
    }
}
