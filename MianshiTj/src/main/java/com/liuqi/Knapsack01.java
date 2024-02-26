package com.liuqi;

public class Knapsack01 {

    // 01背包问题解决算法
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                // 当前物品的重量大于背包容量，不能选择
                if (weights[i - 1] <= j) {
                    // 能够装下当前物品，选择装或不装
                    // 因为dp[i][j]表示的是前i个物品中能够装下重量为j的背包的最大价值，所以dp[i][j] = max(dp[i - 1][j], values[i - 1] + dp[i - 1][   j - weights[i - 1]])
                    // 因为dp[i - 1][j - weights[i - 1]]表示的是前i-1个物品中能够装下重量为j - weights[i - 1]的背包的最大价值，所以dp[i - 1][j - weights[i - 1]]表示的是前i-1个物品中能够装下重量为j - weights[i - 1]的背包的最大价值
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else {
                    // 装不下当前物品，只能选择不装
                    // 因为dp[i][j]表示的是前i个物品中能够装下重量为j的背包的最大价值，所以dp[i][j] = dp[i - 1][j]
                    // 因为当前物品装不下，所以最大价值还是前i-1个物品能够装下的最大价值
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("01背包问题的最大价值为：" + maxValue);
    }
}
