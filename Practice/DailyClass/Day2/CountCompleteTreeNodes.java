package DailyClass.Day2;

import java.util.*;

/*
* Count Complete Tree Nodes

* Problem Statement
* A data organization system stores its information in the form of a complete binary tree, where each node represents a data record.

* The tree follows a specific structure:

* Every level of the tree, except possibly the last level, is completely filled.

* The nodes in the last level are filled from left to right, without leaving any gaps between them.

* You are given the root node of a complete binary tree. Your task is to determine the total number of nodes present in the tree and return that count.

* Important: Your algorithm must run in less than O(n) time complexity, where n represents the total number of nodes in the tree.

* Understanding a Complete Binary Tree
* A complete binary tree follows these rules:

* All levels before the last level must be completely filled.

* The last level may be partially filled.

* Nodes in the last level must always occupy the leftmost available positions.

* For example, the following is a complete binary tree: 
*     1
*    / \
*   2   3
*  / \ /
* 4  5 6

* The last level is not completely filled, but all its nodes are positioned as far left as possible.

* Example 1
* Input: root = [1,2,3,4,5,6]
* Output: 6
* Explanation: The given tree contains six nodes:

* Root node: 1

* Second level: 2, 3

* Third level: 4, 5, 6
* Since there are six nodes in total, the answer is 6.

* Example 2
* Input: root = []
* Output: 0
* Explanation: The given tree is empty and does not contain any nodes. Therefore, the total number of nodes is 0.

* Example 3
* Input: root = [1]
* Output: 1
* Explanation: The tree contains only one node, which is the root node. Therefore, the total number of nodes is 1.

* Constraints

* The number of nodes in the tree is in the range [0, 5 * 10^4].

* 0 <= Node.val <= 5 * 10^4

* The given tree is guaranteed to be a complete binary tree.

*/
public class CountCompleteTreeNodes {
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

    public static int find(TreeNode root) {
        // Write your code here (Target: < O(n) time complexity)
        return 0;
    }

    public static void main(String[] args) {
        Integer[][] testCases = {
            {1, 2, 3, 4, 5, 6},                         // Sample 1: Last level partially filled (6 nodes)
            {},                                         // Sample 2: Empty tree (0 nodes)
            {1},                                        // Sample 3: Single root node (1 node)
            {1, 2},                                     // Edge Case: Root + left child only (2 nodes)
            {1, 2, 3},                                  // Edge Case: Perfect tree of height 1 (3 nodes)
            {1, 2, 3, 4},                               // Edge Case: Only 1 node on last level (4 nodes)
            {1, 2, 3, 4, 5, 6, 7},                      // Edge Case: Perfect tree of height 2 (7 nodes)
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},    // Medium complete tree (12 nodes)
            {0, 0, 0, 0, 0}                             // Edge Case: Zero values in nodes (5 nodes)
        };

        int[] expected = {6, 0, 1, 2, 3, 4, 7, 12, 5};

        runTests(testCases, expected);
    }

    private static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();
            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                q.offer(curr.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    private static void runTests(Integer[][] testCases, int[] expected) {
        int passed = 0;
        for (int i = 0; i < testCases.length; i++) {
            TreeNode root = buildTree(testCases[i]);
            int actual = find(root);
            boolean isPass = (actual == expected[i]);
            if (isPass) passed++;

            System.out.printf("Test Case %d (size %d): %s | Expected: %d, Got: %d%n",
                    i + 1, testCases[i].length, isPass ? "PASSED ✅" : "FAILED ❌", expected[i], actual);
        }
        System.out.printf("\nSummary: %d/%d test cases passed.%n", passed, testCases.length);
    }
}