package Schedule.Day2;
public class MazminumAvgsubArray1 {
    public static double find(int [] nums , int k ) {
        double sum = 0 ;
        for(int i = 0 ; i < k ; i++){
            sum += nums[i];
        }
        double max = sum;
        int start = 0;
        int end = k;
        while(end<nums.length){
            sum -=nums[start];
            start++;
            sum+=nums[end];
            end++;
            max = Math.max(max,sum);
        }
        double avg = max/k;
        return avg;
    }
    public static void main(String[] args) {
        int [] nums ={1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(find(nums, k ));

    }
}
