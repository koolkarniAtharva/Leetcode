package Schedule.Day1;

import java.util.*;

public class subarraysumequalsk {
    public static int find(int [] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int count = 0 ,sum = 0 ;
        for(int i = 0 ; i < nums.length;i++){
            sum += nums[i];
            if(hm.containsKey(sum-k)){
                count+=hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        return count ;
    }
    public static void main(String[] args) {
        int [] nums ={2,3,-5,5,-5,1,4};
        int k = 5;
        find(nums, k);
    }
}
