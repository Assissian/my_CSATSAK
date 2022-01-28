package com;
import java.util.HashMap;
import java.util.Random;

public class Week8 {
    static Random random = new Random();
    public static void test() {
        System.out.println(task1("abbc", "dog cat cat fish"));
        System.out.println(task2(new int[]{1,2,2,3,0}));
        for (int i = 0; i < 5; i++) {
            int target = random.nextInt(15) - 3;
            System.out.println("target " + target + "\tresult " + task3(new int[]{0,4,5,6,8}, target));
        }
    }

    public static void main(String[] args) {
//        int target = random.nextInt(15) - 3;
//        System.out.println(target);
//        System.out.println("target" + target + "\tresult" + task3(new int[]{0,4,5,6,8}, target));
//        System.out.println(task2(new int[]{1,2,2,3,0}));
//        System.out.println(task1("abbc", "dog cat cat fish"));
        test();
    }

    public static boolean task1(String pattern, String str) {
        boolean res = true;
        String[] s = str.split(" ");
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length() && res; i++) {
            String sub = pattern.substring(i, i+1);
            if(map.get(sub) != null) {
                if(!s[i].equals(map.get(sub)))
                    res = false;
            }
            map.put(sub, s[i]);
        }
        return res;
    }

    public static int task2(int[] nums) {
        int res = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) != null) {
                if(map.get(nums[i])) {
                    res = nums[i];
                    break;
                }
            }
            map.put(nums[i], true);
        }
        return res;
    }

    public static int task3(int[] nums, int target) {
        int res = -1;
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(target < nums[mid]) {
                high = mid - 1;
            }else if(target > nums[mid]) {
                low = mid + 1;
            }else {
                res = mid;
                break;
            }
        }
        return res;
    }
}
