package DailyClass.Day3;

import java.util.*;

/*
- *The Enchanted Zigzag Tree**

- *The Legend (Problem Statement)**
- Imagine a mystical tree with enchanted nodes, each containing a precious treasure (an integer value). You are a brave explorer tasked with traversing this tree level by level. However, the tree's magic requires a specific path: at each descending level, the wind changes direction.

- You must collect the treasures in a zigzag fashion: start at the root and go left to right. At the next level, you must gather them from right to left. Then, left to right again, alternating with every drop in depth. Your goal is to return a log (a list of lists) documenting the treasures you collected at each level.

- *Example 1:**
- Input: `root = [3, 9, 20, null, null, 15, 7]`
- Output: `[[3], [20, 9], [15, 7]]`

- *Example 2:**
- Input: `root = [1]`
- Output: `[[1]]`

- *Example 3:**
- Input: `root = []`
- Output: `[]`

- *Constraints:**
- The tree has up to 2000 nodes.
- Each node's treasure value ranges from `-100` to `100`.
*/
public class EnchantedZigzagTree {

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

    public static List<List<Integer>> find(TreeNode root) {
        // Write your code here
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Integer[][] testCases = {
            {3, 9, 20, null, null, 15, 7},              // Sample 1: Standard zigzag traversal
            {1},                                        // Sample 2: Single root node
            {},                                         // Sample 3: Empty tree
            {1, 2, 3, 4, 5, 6, 7},                      // Edge Case: Complete binary tree (3 levels)
            {1, 2, null, 3, null, 4},                   // Edge Case: Left-skewed tree
            {1, null, 2, null, 3, null, 4},             // Edge Case: Right-skewed tree
            {-100, -50, 50, -10, 0, 10, 100},           // Edge Case: Negative & boundary values
            {1, 2, 3, 4, null, null, 5}                 // Edge Case: Sparse outer branches
        };

        List<List<List<Integer>>> expected = Arrays.asList(
            Arrays.asList(
                Collections.singletonList(3),
                Arrays.asList(20, 9),
                Arrays.asList(15, 7)
            ),
            Collections.singletonList(
                Collections.singletonList(1)
            ),
            Collections.emptyList(),
            Arrays.asList(
                Collections.singletonList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6, 7)
            ),
            Arrays.asList(
                Collections.singletonList(1),
                Collections.singletonList(2),
                Collections.singletonList(3),
                Collections.singletonList(4)
            ),
            Arrays.asList(
                Collections.singletonList(1),
                Collections.singletonList(2),
                Collections.singletonList(3),
                Collections.singletonList(4)
            ),
            Arrays.asList(
                Collections.singletonList(-100),
                Arrays.asList(50, -50),
                Arrays.asList(-10, 0, 10, 100)
            ),
            Arrays.asList(
                Collections.singletonList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5)
            )
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

    private static void runTests(Integer[][] testCases, List<List<List<Integer>>> expected) {
        int passed = 0;
        for (int i = 0; i < testCases.length; i++) {
            TreeNode root = buildTree(testCases[i]);
            List<List<Integer>> actual = find(root);
            boolean isPass = Objects.equals(actual, expected.get(i));
            if (isPass) passed++;

            System.out.printf("Test Case %d: %s | Expected: %s, Got: %s%n",
                    i + 1, isPass ? "PASSED ✅" : "FAILED ❌", expected.get(i), actual);
        }
        System.out.printf("\nSummary: %d/%d test cases passed.%n", passed, testCases.length);
    }
}