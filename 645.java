class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1]; // +1 because nums are from 1 to n
        int duplicate = -1, missing = -1;

        // Count frequency of each number
        for (int num : nums) {
            count[num]++;
        }

        // Find duplicate and missing
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 0) {
                missing = i;
            } else if (count[i] == 2) {
                duplicate = i;
            }
        }

        return new int[]{duplicate, missing};
    }
}
