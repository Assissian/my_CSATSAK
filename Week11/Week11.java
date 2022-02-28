package com.atcwl.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week11 {
    public static void main(String[] args) {
        findMaxRepeatNum();
        plantFlower(2, new int[]{0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1});
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(1, 2));
//        list.add(Arrays.asList(1, 3));
        eraseOverlapIntervals(list);
    }

    public static void findMaxRepeatNum() {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] == nums[i+len/2]) {
                System.out.println("重复数字为：" + nums[i]);
                break;
            }
        }
    }

    public static void plantFlower(int n, int[] nums) {
        int pre = -1, total = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if((i - pre) > 2)
                    total += (i - pre) / 2 - 1;
                pre = i;
            }
        }
        System.out.println(total >= n);
    }

    public static void eraseOverlapIntervals(List<List<Integer>> lists) {
        int minTotal = 0;
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list1 = lists.get(i);
            for (int j = i+1; j < lists.size(); j++) {
                if(list1.get(0) >= lists.get(j).get(0) && list1.get(1) <= lists.get(j).get(1)) {
                    lists.remove(j);
                    minTotal++;
                    i--;
                }
            }
        }
        System.out.println("minTotal = " + minTotal);
    }
}
