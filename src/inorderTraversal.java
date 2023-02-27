import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public List<Integer> inorderTraversalByRecursion(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		return list;
	}

	public void inorder(TreeNode root, List<Integer> list){
		if (root == null){
			return;
		}
		else {
			inorder(root.left, list);
			list.add(root.val);
			inorder(root.right, list);
		}
	}

	public static List<Integer> inorderTraversalByStack(TreeNode root){
		class colorNode{
			TreeNode node;
			boolean flag;
			colorNode(TreeNode node, boolean flag){
				this.node = node;
				this.flag = flag;
			}
		}
		Stack<colorNode> treeStack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		treeStack.push(new colorNode(root, false));
		while (!treeStack.isEmpty()){
			colorNode cn = treeStack.pop();
			if (!cn.flag){
				if (cn.node.right != null){
					treeStack.push(new colorNode(cn.node.right, false));
				}
				treeStack.push(new colorNode(cn.node, true));
				if (cn.node.left != null){
					treeStack.push(new colorNode(cn.node.left, false));
				}
			}else {
				res.add(cn.node.val);
			}
		}
		return res;

	}

	public static void main(String[] args) {
		TreeNode treeNode3 = new TreeNode(3,null,null);
		TreeNode treeNode2 = new TreeNode(2,treeNode3,null);
		TreeNode treeNode1 = new TreeNode(1,null,treeNode2);

		List<Integer> res = inorderTraversal.inorderTraversalByStack(treeNode1);
		System.out.println(res);

	}

}
