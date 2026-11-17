package DailyClass.Day3;

import java.util.*;

/*
* *The Observer on the Right**

* *The Legend (Problem Statement)**
* Imagine you are standing on a tall watchtower to the far right of a dense, magical binary tree. Each node in the tree holds a precious treasure (an integer value). Because the foliage is thick, nodes situated on the left are completely obscured by any nodes on their right at the same height. Your task is to report the treasures you can actually see from your right-side vantage point, ordered from the top of the tree down to the bottom.

* *Example 1:**
* Input: `root = [1, 2, 3, null, 5, null, 4]`
* Output: `[1, 3, 4]`

* *Example 2:**
* Input: `root = [1, 2, 3, 4, null, null, null, 5]`
* Output: `[1, 3, 4, 5]`

* *Example 3:**
* Input: `root = [1, null, 3]`
* Output: `[1, 3]`

* *Example 4:**
* Input: `root = []`
* Output: `[]`

* *Constraints:**
* The number of nodes in the tree is in the range `[0, 100]`.
* Each node's treasure value ranges from `-100` to `100`.
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class ObserveronRight {
    public static List<Integer> find(TreeNode root) {
        // Write your code here
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Integer[][] testCases = {
            {1, 2, 3, null, 5, null, 4},                // Sample 1: Standard tree
            {1, 2, 3, 4, null, null, null, 5},          // Sample 2: Deep left subtree peeks through at bottom
            {1, null, 3},                               // Sample 3: Right-skewed 2 nodes
            {},                                         // Sample 4: Empty tree
            {10},                                       // Edge Case: Single root node
            {1, 2, null, 3, null, 4},                   // Edge Case: Left-skewed tree (all visible from right)
            {1, null, 2, null, 3, null, 4},             // Edge Case: Right-skewed tree (all visible)
            {-100, -50, 0, null, 50, null, 100},        // Edge Case: Negative & boundary values
            {1, 2, 3, 4, 5, 6, null, 7}                 // Edge Case: Left child extends deeper than right
        };

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 3, 4),
            Arrays.asList(1, 3, 4, 5),
            Arrays.asList(1, 3),
            Collections.emptyList(),
            Collections.singletonList(10),
            Arrays.asList(1, 2, 3, 4),
            Arrays.asList(1, 2, 3, 4),
            Arrays.asList(-100, 0, 100),
            Arrays.asList(1, 3, 6, 7)
        );

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

    private static void runTests(Integer[][] testCases, List<List<Integer>> expected) {
        int passed = 0;
        for (int i = 0; i < testCases.length; i++) {
            TreeNode root = buildTree(testCases[i]);
            List<Integer> actual = find(root);
            boolean isPass = Objects.equals(actual, expected.get(i));
            if (isPass) passed++;

            System.out.printf("Test Case %d: %s | Expected: %s, Got: %s%n",
                    i + 1, isPass ? "PASSED ✅" : "FAILED ❌", expected.get(i), actual);
        }
        System.out.printf("\nSummary: %d/%d test cases passed.%n", passed, testCases.length);
    }
}