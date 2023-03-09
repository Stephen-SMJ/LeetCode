package jianzhi;

public class isSubStructure {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null || B==null){
            return false;
        }
        return contain(A,B) || isSubStructure(A.left,B.left) || isSubStructure(A.right,B.right);
    }

    public boolean contain(TreeNode A, TreeNode B){
        if (B==null){ // must to b==null first. becasue null definately != A.val
            return true;
        }
        if (A==null || A.val != B.val){
            return false;
        }
        return contain(A.left,B.left) && contain(A.right,B.right);

    }

}
