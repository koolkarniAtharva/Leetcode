package DailyClass.Day1;
/*  **Robot Navigation in a Warehouse**

**Problem Statement**
A warehouse uses an automated robot to transport packages from its starting station to a designated destination. The warehouse is represented as a rectangular grid consisting of m rows and n columns. The robot initially starts at the top-left corner of the warehouse, at position (0, 0), and needs to reach the bottom-right corner, at position (m-1, n-1).

The robot has two possible movements at any given position:

* Move Right: The robot can move one cell towards the right.
* Move Down: The robot can move one cell downwards.

The robot cannot move upwards or towards the left. The warehouse management team wants to determine how many different routes the robot can take to reach its destination while following these movement restrictions.

Given two integers, m and n, representing the number of rows and columns in the warehouse grid, respectively, calculate and return the total number of unique paths the robot can take to reach the bottom-right corner from the top-left corner.

**Example 1**
Input: m = 3, n = 7
Output: 28
Explanation: The warehouse consists of 3 rows and 7 columns. The robot starts at the top-left corner and must reach the bottom-right corner. By moving only right or down, the robot can take a total of 28 different routes to reach its destination.

**Example 2**
Input: m = 3, n = 2
Output: 3
Explanation: The warehouse consists of 3 rows and 2 columns. The robot can reach its destination using the following three possible routes:

1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Therefore, the total number of unique paths is 3.

**Constraints**

* 1 <= m, n <= 100
* The test cases are designed so that the final answer will not exceed 2 * 10^9.
*/
public class Robotnavigation {
    public static int find(int m, int n) {
        int [][] dp = new int [m][n];
            if(m == 0 && n == 0){
                return 0 ;
            }
            if(m == 1 && n == 1 ){
                return 1 ;
            }
            for(int i = 0 ; i < m;i++){
                for(int j = 0; j <n ; j++){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1 ;
                    }
                    else{
                        dp[i][j] = dp[i][j-1]+ dp[i-1][j];
                    }
                }
            }

            
            
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {3, 7},     // Sample 1: Standard grid
            {3, 2},     // Sample 2: Tall grid
            {1, 1},     // Edge Case: Single cell (already at destination)
            {1, 100},   // Edge Case: Single row (only right moves possible)
            {100, 1},   // Edge Case: Single column (only down moves possible)
            {2, 2},     // Smallest 2D grid
            {10, 10},   // Square grid
            {51, 9},    // Asymmetric grid
            {16, 16}    // Large values near integer overflow boundary (155,117,520)
        };
        int[] expected = {28, 3, 1, 1, 1, 2, 48620, 1916797311, 155117520};

        runTests(testCases, expected);
    }

    private static void runTests(int[][] testCases, int[] expected) {
        int passed = 0;
        for (int i = 0; i < testCases.length; i++) {
            int m = testCases[i][0];
            int n = testCases[i][1];
            int actual = find(m, n);
            boolean isPass = (actual == expected[i]);
            if (isPass) passed++;

            System.out.printf("Test Case %d (%dx%d): %s | Expected: %d, Got: %d%n",
                    i + 1, m, n, isPass ? "PASSED ✅" : "FAILED ❌", expected[i], actual);
        }
        System.out.printf("\nSummary: %d/%d test cases passed.%n", passed, testCases.length);
    }
}

