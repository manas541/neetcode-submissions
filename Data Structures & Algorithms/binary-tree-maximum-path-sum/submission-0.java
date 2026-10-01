class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxSum;
    }

    private int maxPath(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(0, maxPath(root.left));
        int rightGain = Math.max(0, maxPath(root.right));

        int currentPath = leftGain + root.val + rightGain;

        maxSum = Math.max(maxSum, currentPath);

        return root.val + Math.max(leftGain, rightGain);
    }
}