package DailyClass.Day2;
/* 
* *Count Servers that Communicate**

* *Problem Statement**
* A data center consists of multiple server machines arranged in a rectangular grid of m rows and n columns. The data center is represented by an integer matrix called grid, where:

* `grid[i][j] = 1` indicates that a server is present at row i and column j.
* `grid[i][j] = 0` indicates that the cell is empty.

* For efficient data exchange, a server can communicate with another server if both servers are located in the same row or the same column.

* Your task is to determine the total number of servers that can communicate with at least one other server. Return the total count of such servers.

* *Example 1**
* Input: `grid = [[1,0], [0,1]]`
* Output: 0
* Explanation: There are two servers in the data center. One is at (0,0) and the other is at (1,1). They are neither in the same row nor in the same column. Therefore, neither server can communicate with another server. The total number is 0.

* *Example 2**
* Input: `grid = [[1,0], [1,1]]`
* Output: 3
* Explanation: There are three servers:

* The server at (0,0) communicates with (1,0) (same column).
* The server at (1,0) communicates with (0,0) (same column) and (1,1) (same row).
* The server at (1,1) communicates with (1,0) (same row).
* All three servers can communicate with at least one other server. Total count is 3.

* *Example 3**
* Input: `grid = [[1,1,0,0], [0,0,1,0], [0,0,1,0], [0,0,0,1]]`
* Output: 4
* Explanation: There are five servers:

* The two servers in the first row can communicate with each other.
* The two servers in the third column can communicate with each other.
* The server at the bottom-right corner (3,3) cannot communicate with any other server because it is the only server in its row and column.
* Therefore, four servers can communicate with at least one other server.

* *Constraints**

* `m == grid.length`
* `n == grid[i].length`
* `1 <= m <= 250`
* `1 <= n <= 250`
* `grid[i][j]` is either 0 or 1.

* Important observation: A server should be counted if there is at least one other server in its row or column. It does not matter whether it can communicate with one server or several servers; it is counted only once.

*/

import java.util.*;
public class CountServerCommunication {


    public static int find(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [] rowCount = new int [m];
        int [] colCount = new int [n];
        int communication = 0;
        for(int i = 0 ; i < rowCount.length ; i++){
            for(int j = 0 ; j < colCount.length ; j++){
                if(grid[i][j] == 1){
                    ++rowCount[i];
                    ++colCount[j]; 
                }
            }
        }
        
        

        for(int i = 0 ; i < rowCount.length ; i++){
            for(int j = 0 ; j < colCount.length; j++){
                if(grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)){
                    communication++;
                }
            }
        }

        return communication;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
            // Sample 1: Diagonal servers (no communication)
            {
                {1, 0},
                {0, 1}
            },
            // Sample 2: L-shaped communication (all 3 connect)
            {
                {1, 0},
                {1, 1}
            },
            // Sample 3: Mixed rows/cols + 1 isolated server
            {
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
            },
            // Edge Case: 1x1 grid with a server (cannot communicate with itself)
            {
                {1}
            },
            // Edge Case: 1x1 grid empty
            {
                {0}
            },
            // Edge Case: All zeros (no servers at all)
            {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            },
            // Edge Case: Single row with multiple servers
            {
                {1, 0, 1, 0, 1}
            },
            // Edge Case: Single column with multiple servers
            {
                {1},
                {0},
                {1},
                {1}
            },
            // Edge Case: Full grid of servers (100% communicate)
            {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
            },
            // Edge Case: Anti-diagonal servers (none share row/col)
            {
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 0}
            }
        };

        int[] expected = {0, 3, 4, 0, 0, 0, 3, 3, 9, 0};

        runTests(testCases, expected);
    }

    private static void runTests(int[][][] testCases, int[] expected) {
        int passed = 0;
        for (int i = 0; i < testCases.length; i++) {
            int[][] gridCopy = new int[testCases[i].length][];
            for (int r = 0; r < testCases[i].length; r++) {
                gridCopy[r] = Arrays.copyOf(testCases[i][r], testCases[i][r].length);
            }

            int actual = find(gridCopy);
            boolean isPass = (actual == expected[i]);
            if (isPass) passed++;

            System.out.printf("Test Case %d (%dx%d): %s | Expected: %d, Got: %d%n",
                    i + 1, testCases[i].length, testCases[i][0].length,
                    isPass ? "PASSED ✅" : "FAILED ❌", expected[i], actual);
        }
        System.out.printf("\nSummary: %d/%d test cases passed.%n", passed, testCases.length);
    }
}

