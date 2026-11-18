package Schedule.Day1 ;
import java.util.*;

public class TwoSum {
    public static int []find(int[]nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int comp = target - nums[i];
            if(hm.containsKey(comp)){
                return new int[]{hm.get(comp),i};
            }
            else{
                hm.put(nums[i], i);
            }
        }
        return new int[]{} ;
    }
   public static void main(String[] args) {
    int [] nums = {2,3,4,5,6,7,8,9,1};
    int target  = 17 ;
    System.out.println(Arrays.toString(find(nums, target)));
   } 
}
