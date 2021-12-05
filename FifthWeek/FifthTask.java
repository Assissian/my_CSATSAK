package com.atcwl.fifthTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FifthTask {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("第一题");
        //System.out.println(reverseNumber());

        System.out.println("第二题");
//        climbStairs();

        System.out.println("第三题");
        int[] nums = new int[]{1,2,3};
        getSubset(nums);
    }

    public static int reverseNumber() {
        String num = in.nextLine();
        if(num == null || "".equals(num)) {
            System.out.println("输入错误");
            return -1;
        }
        int flag = 1;
        if(num.contains("-")) {
            num = num.substring(1);
            flag = 0;
        }
        StringBuilder stringBuilder = new StringBuilder(num);
        stringBuilder.reverse();
        num = stringBuilder.toString();

        if(flag == 0)
            num = "-" + num;

        return Integer.parseInt(num);
    }

    public static void climbStairs() {
        System.out.println("请输入台阶层数：");
        int n = in.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }

    public static void getSubset(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        sum(list, new ArrayList<>(), nums, 0);
        System.out.println(list);
    }

    public static void sum(List<List<Integer>> list, List<Integer> tempList, int[] nums, int index) {
        list.add(new ArrayList<>(tempList));

        for(int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);System.out.println(tempList.size());
            sum(list, tempList, nums, i+1);

            tempList.remove(tempList.size()-1);
        }

    }

}

