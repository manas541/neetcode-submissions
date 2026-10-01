public class Codec {

    // Serialize
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);

        serializeHelper(root.right, sb);
    }


    // Deserialize
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        Queue<String> queue = new LinkedList<>();

        for (String value : values) {
            queue.offer(value);
        }

        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {

        String value = queue.poll();

        if (value.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = deserializeHelper(queue);

        root.right = deserializeHelper(queue);

        return root;
    }
}