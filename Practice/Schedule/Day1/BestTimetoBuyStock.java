package Schedule.Day1;

public class BestTimetoBuyStock {
    public static int find(int [] nums) {
        int maxProfit = 0;
        int currProfit = 0;
        int buyprice = nums[0];
        for( int i = 1; i < nums.length; i++){
            if(nums[i] < buyprice){
                buyprice = nums[i];
            }
            currProfit = nums[i] - buyprice;
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit ;
    }
    public static void main(String[] args) {
        int [] nums = {7,2,4,5,1,3,6,4};
        System.out.println(find(nums));
    }
}
