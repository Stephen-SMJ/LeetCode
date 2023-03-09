package jianzhi;


public class isSymmetric {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return false;
        }
        return nodeSyymmetric(root.left, root.right);
    }
    public  static boolean nodeSyymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }else if ((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if (left.val == right.val){
            return nodeSyymmetric(left.left, right.right) && nodeSyymmetric(left.right, right.left);
        }
        return false;
    }
}
