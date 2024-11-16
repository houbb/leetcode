package com.github.houbb.leetcode.datastruct.sweepline;

import java.util.*;

public class T850_rectangleArea_v1_split {

    public int rectangleArea(int[][] rectangles) {
        final int MOD = 1_000_000_007;
        int n = rectangles.length;

        // Step 1: 收集并排序所有的垂直边界 (sweeps)
        Set<Integer> xSet = new HashSet<>();
        for (int[] rect : rectangles) {
            xSet.add(rect[0]); // 左边界
            xSet.add(rect[2]); // 右边界
        }
        List<Integer> sweeps = new ArrayList<>(xSet);
        Collections.sort(sweeps);

        // Step 2: 收集并排序所有的水平边界 (hbounds)
        Set<Integer> ySet = new HashSet<>();
        for (int[] rect : rectangles) {
            ySet.add(rect[1]); // 底边界
            ySet.add(rect[3]); // 顶边界
        }
        List<Integer> hbounds = new ArrayList<>(ySet);
        Collections.sort(hbounds);

        int m = hbounds.size();
        long ans = 0;

        // Step 3: 遍历每个垂直区间和水平区间
        for (int i = 0; i < sweeps.size() - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                // 构造当前区间 [x1, x2] 和 [y1, y2]
                int x1 = sweeps.get(i), x2 = sweeps.get(i + 1);
                int y1 = hbounds.get(j), y2 = hbounds.get(j + 1);

                // Step 4: 检查当前区间是否被至少一个矩形完全覆盖
                if (check(new int[]{x1, y1, x2, y2}, rectangles)) {
                    // 累加当前区间面积
                    ans += (long) (y2 - y1) * (x2 - x1);
                    ans %= MOD;
                }
            }
        }

        return (int) ans;
    }

    // 检查当前区间 [x1, y1, x2, y2] 是否被至少一个矩形完全覆盖
    private boolean check(int[] rect, int[][] rectangles) {
        int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
        for (int[] r : rectangles) {
            if (x1 >= r[0] && x2 <= r[2] && y1 >= r[1] && y2 <= r[3]) {
                return true;
            }
        }
        return false;
    }

}
