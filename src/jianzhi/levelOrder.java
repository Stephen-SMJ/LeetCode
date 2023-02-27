package jianzhi;

import javax.print.attribute.standard.PresentationDirection;
import java.util.*;

public class levelOrder {  //树的遍历问题用队列，双端队列，addfirst 先进后出， addlast先进先出（正常调用poll的情况下）
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int[] levelOrder1(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> nodeQue = new LinkedList<>();
        nodeQue.add(root);
        while (!nodeQue.isEmpty()){ //对象不为空不能用!=null，只能用isEmpty判断.
            TreeNode node = nodeQue.poll();
            arr.add(node.val);
        if (node.left != null)
            nodeQue.add(node.left);
        if (node.right != null)
            nodeQue.add(node.right);
        }
        int[] res = new int[arr.size()];
        for (int i=0; i<res.length; i++){
            res[i] = arr.get(i);
        }
        return res;
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {//每层打印在一个数组中
        ArrayList<List<Integer>> arr = new ArrayList<>();
        if (root == null) return arr;
        Queue<TreeNode> nodeQue = new LinkedList<>();
        nodeQue.add(root);
        while (!nodeQue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = nodeQue.size(); i>0; i--){
                TreeNode node = nodeQue.poll();
                tmp.add(node.val);
                if (node.left!=null)
                    nodeQue.add(node.left);
                if (node.right != null)
                    nodeQue.add(node.right);
            }
            arr.add(tmp);
        }
        return arr;
    }
    public List<List<Integer>> levelOrder3(TreeNode root) { //Z字型打印
        ArrayList<List<Integer>> arr = new ArrayList<>();
        if (root == null) return arr;
        Queue<TreeNode> nodeQue = new LinkedList<>();
        nodeQue.add(root);
        int count = 1;
        while (!nodeQue.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<>();
            count++;
            for (int i = nodeQue.size(); i>0; i--){
                TreeNode node = nodeQue.poll();
                if (count % 2 == 0)
                    tmp.addFirst(node.val);
                else
                    tmp.addLast(node.val);
                if (node.right != null)
                    nodeQue.add(node.right);
                if (node.left!=null)
                    nodeQue.add(node.left);
            }
            arr.add(tmp);
        }
        return arr;
    }
}
