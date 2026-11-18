package Schedule.Day1;

public class RunningSum1DArray {

    public static int [] find(int[] nums) {
        int[] prefix = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        for(int i= 0 ; i< nums.length;i++){
            System.out.print(" "+nums[i]+" ");
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        find(nums);
    }
}
