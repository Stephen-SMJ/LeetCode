package jianzhi;

public class mirrorTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        recur(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public static void recur(TreeNode node){
        TreeNode tmpNode = node.left;
        node.left = node.right;
        node.right = tmpNode;
    }
}
