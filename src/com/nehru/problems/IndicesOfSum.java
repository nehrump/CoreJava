package com.nehru.problems;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class IndicesOfSum {

    public static void main(String[] args) {


        int[] index=findSum(new int[]{1,2,3,4,5},8);
        Arrays.stream(index).forEach(System.out::println);

        int[] index2=findSum(new int[]{1,2,3,4,5},7);
        Arrays.stream(index2).forEach(System.out::println);
     }


    private static int[] findSum(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int remainder=target-nums[i];
            if(map.containsKey(remainder)){
                return new int[]{i,map.get(remainder)};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}

