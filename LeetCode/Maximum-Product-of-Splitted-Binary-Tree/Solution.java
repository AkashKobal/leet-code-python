/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SumNode {
    public long sumBelow;
    public SumNode left;
    public SumNode right;

    SumNode() {
        this.sumBelow = 0;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public int maxProduct(TreeNode root) {
        SumNode sumRoot = new SumNode();

        // Use recursion to build a tree where:
        // "Each node holds the sum of all nodes below it + the value of itself"
        buildSumTree(root, sumRoot);

        // The overall total sum will be the sum below the root.
        long totalTreeSum = sumRoot.sumBelow, maxProduct = Long.MIN_VALUE;

        Queue<SumNode> queue = new ArrayDeque<SumNode>();
        queue.offer(sumRoot);

        // Run BFS to visit each node.
        // For any particular node:
        // Product is the sumBelow the node and the sum of the rest of the tree
        // Which is = sumBellow * (totalTreeSum - sumBelow) at any given node.
        while (!queue.isEmpty()) {
            SumNode current = queue.poll();

            maxProduct = Math.max(
                maxProduct, current.sumBelow * (totalTreeSum - current.sumBelow)
            );

            if (current.left != null)
                queue.offer(current.left);

            if (current.right != null)
                queue.offer(current.right);
        }

        return (int) (maxProduct % 1000000007);
    }

    public void buildSumTree(TreeNode root, SumNode sumRoot) {
        if (root == null)
            return;

        SumNode leftSumNode = new SumNode(), rightSumNode = new SumNode();

        if (root.left != null) {
            buildSumTree(root.left, leftSumNode);
        }

        if (root.right != null) {
            buildSumTree(root.right, rightSumNode);
        }

        sumRoot.sumBelow = root.val + leftSumNode.sumBelow + rightSumNode.sumBelow;
        sumRoot.left = leftSumNode;
        sumRoot.right = rightSumNode;

        return;
    }
}