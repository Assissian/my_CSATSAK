package com.atcwl.sixthTask;

public class SixthTask {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 19, 2, 1, 39, 13, 9, 23, 10, 5};
//        System.out.println("冒泡排序");
//        bubbleSort(nums);
//        System.out.println("\n插入排序");
//        insertionSort(nums);
//        System.out.println("\n快速排序");
//        quickSort(nums, 0, nums.length-1);
//        for(int i : nums)
//            System.out.print(i + " ");
//        System.out.println("\n合并排序");
//        mergeSort(nums, 0, nums.length-1);
//        for(int i : nums)
//            System.out.print(i + " ");
//        System.out.println("\n堆排序");
//        leapSort(nums);
    }

    //冒泡排序
    public static void bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = 0; j < nums.length-i-1; j++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        for(int num : nums)
            System.out.print(num + " ");
    }

    //插入排序
    public static void insertionSort(int[] nums) {
        int temp, i, j;
        for(i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                temp = nums[i];
                nums[i] = nums[i-1];
                for(j = i-1; j >= 0 && nums[j] > temp; j--) {
                    nums[j+1] = nums[j];
                }
                nums[j+1] = temp;
            }
        }

        for(int num : nums)
            System.out.print(num + " ");
    }

    //快速排序
    public static void quickSort(int[] nums, int low, int high) {
        if(low >= high)
            return;
        int j = parition(nums, low, high);
        quickSort(nums, low, j-1);
        quickSort(nums, j+1, high);
    }

    public static int parition(int[] nums, int low, int high) {
        int flag = nums[low], i = low, j = high+1;
        while(true) {
            while(nums[++i] < flag)
                if(i == high)
                    break;
            while(nums[--j] > flag)
                if(j == low)
                    break;

            if(i >= j)
                break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[low] = nums[j];
        nums[j] = flag;
        return j;
    }

    //归并排序
    public static void mergeSort(int[] nums, int low, int high) {
        if(low >= high)
            return;

        mergeSort(nums, low, (low+high)/2);
        mergeSort(nums, (low+high)/2+1, high);

        merge(nums, low, (low+high)/2, high);
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i = low, j = mid+1, count = 0;
        while(i <= mid && j <= high) {
            if(nums[i] < nums[j])
                temp[count++] = nums[i++];
            else
                temp[count++] = nums[j++];
        }
        while(i <= mid)
            temp[count++] = nums[i++];
        while(j <= high)
            temp[count++] = nums[j++];
        for(int k = 0; k < count; k++) {
            nums[k+low] = temp[k];
        }
    }

    //堆排序
    public static void leapSort(int[] nums) {
        int[] onums = new int[nums.length+1];

        for(int i = 0; i < nums.length; i++)
            onums[i+1] = nums[i];

        int N = onums.length-1;
        for(int i = N/2; i >= 1; i--)
            sink(onums, i, N);

        while(N > 1) {
            int temp = onums[N];
            onums[N] = onums[1];
            onums[1] = temp;
            N--;
            sink(onums, 1, N);
        }

        for(int i = 1; i < onums.length; i++)
            System.out.print(onums[i] + " ");
    }

    //4, 19, 2, 1, 39, 13, 9, 23, 10, 5

    public static void sink(int[] nums, int index, int N) {
        while(2 * index <= N) {
            int j = 2 * index;
            if(j < N && nums[j] < nums[j+1])
                j++;
            if(nums[index] > nums[j])
                break;
            int temp = nums[index];
            nums[index] = nums[j];
            nums[j] = temp;
            index = j;
        }
    }

}
