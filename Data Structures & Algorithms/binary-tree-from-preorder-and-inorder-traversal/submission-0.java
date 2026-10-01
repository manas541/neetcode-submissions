class Solution {
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // No elements left
        if (left > right) {
            return null;
        }

        // Preorder gives us the root
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find root's position in inorder
        int mid = map.get(rootValue);

        // Build left subtree
        root.left = build(preorder, left, mid - 1);

        // Build right subtree
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}