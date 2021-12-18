package org.example.algorathmTask;

import java.util.*;

public class Algorithm {
    public static void main(String[] args) {
        System.out.println("第一题结果");
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,2,4,3};
        findLarge(nums1, nums2);
        System.out.println("第二题结果");
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        System.out.println(judgeSequence(pushed, popped));
        System.out.println("第三题结果");
        int[] ints = new int[]{1,2,3,2,3,2};
        uniqueElement(ints);
    }

    //第一题
    public static void findLarge(int[] nums1, int[] nums2) {
        int[] result = new int[nums2.length];
        String str = "";
        for(int i : nums2)
            str += i;
        Stack<Integer> temp = new Stack<>();
        for(int i = nums2.length-1; i >= 0; i--) {
            while(!temp.isEmpty() && nums2[temp.peek()-1] <= nums2[i])
                temp.pop();
            result[i] = temp.isEmpty() ? -1 : nums2[i];
            temp.push(nums2[i]);
        }
        List<Integer> res = new ArrayList<>();
        for(int i : nums1) {
            int index = str.indexOf("" + i);
            res.add(result[index] == -1 ? result[index] : nums2[result[index]]);
        }
        System.out.println(res);
    }

    //第二题
    public static boolean judgeSequence(int[] pushed, int[] popped) {
        Stack<Integer> temp = new Stack<>();
        int j = 0;
       for(int i = 0; i < pushed.length; i++) {
           temp.push(pushed[i]);
           while(!temp.isEmpty() && j < popped.length && temp.peek() == popped[j]) {
               temp.pop();
               j++;
           }
       }

        return temp.isEmpty();
    }

    //第三题
    public static void uniqueElement(int[] nums) {
        HashMap maps = new HashMap<Integer, Integer>();
        int result = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            maps.put(nums[i], i);
        for(int i = 0; i < nums.length; i++) {
            if(maps.get(nums[i]).equals(i) && !list.contains(nums[i])) {
                result += nums[i];
            }
            else
                list.add(nums[i]);
        }
        System.out.println(result);
    }
}
