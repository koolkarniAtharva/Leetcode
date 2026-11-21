package Schedule.Day2;

public class ContainerwithMostwater {
    public static int find(int [] nums) {
        int i = 0 , j = nums.length-1;
        int max = 0;
        int height = 0;
        int width = 0;
        while(i<j){
            height = Math.min(nums[i], nums[j]);
            width = (j-i); 
            max = Math.max(max,height * width );
            if(nums[i]<nums[j]){
                i++;
            }
            else if (nums[i] == nums[j]){
                i++;
                j--;
            }
            else{
                j--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(find(nums));
    }
}
