package DailyClass.Day1;
import java.util.*;
/*
* Emergency Rescue Boat Allocation**

* Problem Statement**
* A coastal rescue team is organizing an evacuation operation to transport people from an island to the mainland using rescue boats. The rescue team has access to an unlimited number of boats. However, each boat has a maximum weight capacity of limit and can accommodate at most two people at a time.

* Every person has an individual weight, represented by an integer array people, where people[i] denotes the weight of the i-th person.

* A boat can carry either one person or two people, provided that the combined weight of the passengers does not exceed the boat's maximum capacity. The rescue team wants to transport everyone safely while using the minimum possible number of boats.

* Your task is to determine and return the minimum number of boats required to transport all the people to the mainland.

* Example 1**
*Input: people = [1, 2], limit = 3
*Output: 1
*Explanation: The combined weight of both people is 1 + 2 = 3, which does not exceed the boat's maximum capacity. Therefore, both people can travel together in a single boat. Minimum number of boats required: 1.

* Example 2**
*Input: people = [3, 2, 2, 1], limit = 3
*Output: 3
*Explanation: The rescue team can arrange the passengers as follows:

*1. Boat 1: People weighing 1 and 2 (Total weight = 3).
*2. Boat 2: One person weighing 2.
*3. Boat 3: One person weighing 3.
*Since each boat can carry at most two people and the combined weight cannot exceed 3, all four people can be transported using 3 boats. Minimum number of boats required: 3.

*Example 3** 
*Input: people = [3, 5, 3, 4], limit = 5
*Output: 4
*Explanation: No two people can travel together because the combined weight of even the two lightest people is 3 + 3 = 6, which exceeds the maximum boat capacity of 5. Therefore, each person must travel separately. Minimum number of boats required: 4.

*Constraints**

* 1 <= people.length <= 5 * 10^4
* 1 <= people[i] <= limit <= 3 * 10^4

* Important Note: Each boat can carry a maximum of two people, regardless of how much weight capacity remains unused. The total weight of the passengers in a boat must never exceed limit.
 */
public class EmergencyResueBoat {
    public static int find(int[] people, int limit) {
        // {3,2,2,1}
        Arrays.sort(people);
        // {1,2,2,3}
        int total = 0 ;
        int i = 0;
        int j = people.length-1;
        while(i<=j){
            if(people[j] + people[i] <= limit){
                    i++;
                    j--;
                    total++;
            }
            else{
                j--;
                total ++;
            }
            
            
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] peopleCases = {
            {1, 2},                         // Sample 1: Exact fit
            {3, 2, 2, 1},                   // Sample 2: Mixed pairing
            {3, 5, 3, 4},                   // Sample 3: No pairs possible
            {5},                            // Edge Case: Single person
            {4, 4, 4, 4},                   // Edge Case: All people equal to limit
            {1, 1, 1, 1, 1},                // Edge Case: Max 2 per boat rule despite spare weight
            {1, 2, 3, 4, 5},                // Sequential weights
            {5, 1, 4, 2},                   // Reverse/unsorted pairing
            {2, 2, 2, 6, 6, 6},             // Heavy + light exact pairing
            {30000, 30000, 1, 1}            // Max constraint values
        };
        int[] limits = {3, 3, 5, 5, 4, 10, 5, 6, 8, 30000};
        int[] expected = {1, 3, 4, 1, 4, 3, 3, 2, 3, 3};

        runTests(peopleCases, limits, expected);
    }

    private static void runTests(int[][] peopleCases, int[] limits, int[] expected) {
        int passed = 0;
        for (int i = 0; i < peopleCases.length; i++) {
            int[] inputCopy = Arrays.copyOf(peopleCases[i], peopleCases[i].length);
            int actual = find(inputCopy, limits[i]);
            boolean isPass = (actual == expected[i]);
            if (isPass) passed++;

            System.out.printf("Test Case %d: %s | Expected: %d, Got: %d%n",
                    i + 1, isPass ? "PASSED ✅" : "FAILED ❌", expected[i], actual);
        }
        System.out.printf("\nSummary: %d/%d test cases passed.%n", passed, peopleCases.length);
    }
}
