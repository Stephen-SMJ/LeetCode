package template;

import java.util.ArrayList;

class TreeNode {
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
public class recursion {
    /**
    递归模板：
    递归应该关心什么：https://lyl0724.github.io/2020/01/25/1/
    1.整个递归的终止条件。
    2.一级递归需要做什么？
    3.应该返回给上一级的返回值是什么？ （递归开始返回是在完成所有的自身调用之后）1 2 3 4 5 -> 5返回 4返回 3返回 2返回 1返回。
     **/

    /*
    104. 二叉树的最大深度
    https://leetcode.cn/problems/maximum-depth-of-binary-tree/
     */
    public int maxDepth(TreeNode root) {
        //1.整个递归的终止条件。
        if (root==null){
            return 0;
        }
        //2.一级递归需要做什么？
        TreeNode cur = root;
        int leftDepth = maxDepth(cur.left);
        int rightDepth = maxDepth(cur.right);
        int depth = Math.max(leftDepth,rightDepth) + 1;
        //应该返回给上一级的返回值是什么？
        return depth;
    }

    /**
     * Leetcode 24. 两两交换链表中的节点
     * https://leetcode.cn/problems/swap-nodes-in-pairs
     */
    public ListNode swapPairsByRecursion(ListNode head) {
        //1. 终止条件：链表只剩一个节点或者没节点了，没得交换了。返回的是已经处理好的链表。
        if (head == null || head.next==null){
            return head;
        }
        //2. 一级递归需要做什么：交换head和head.next(next)
        //一共三个节点:head, next, swapPairs(next.next)
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //3. 返回给上一级的是当前已经完成交换后，即处理好了的链表部分。
        return next;
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        ListNode first;
        ListNode second;
        ListNode third;

        while(cur.next!=null && cur.next.next != null){ //为什么要有一个cur.next!=null? 避免空指针异常，
            // 如果cur.next=null了那么next.next会报空指针异常。注意，java中异常在判断语句里也会直接被跑出。
            first = cur.next;
            second = cur.next.next;
            third = cur.next.next.next;
            cur.next = second;
            first.next = third;
            second.next = first;
            cur = first; //cur是要交换的两个节点的前一个，交换后first是第二个节点，所以是first。
        }
        return dummy.next;
    }


    /**
     * Leetcode 110. 平衡二叉树
     * https://leetcode.cn/problems/balanced-binary-tree/submissions/
     */

    private class returnNode{
        boolean isBt;
        int depth;
        returnNode(){}
        returnNode(int depth, boolean isBt){
            this.depth=depth;
            this.isBt=isBt;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return isBst(root).isBt;
    }

    public returnNode isBst(TreeNode root){
        if(root==null){  //1.终止条件：递归到最后一个节点时，这个节点没有子树了，深度为0，并且是平衡二叉树。
            return new returnNode(0,true);
        }


        /*
        2.第一层递归应该做什么 判断是否是平衡二叉树。三个节点 root left right.
        root为bst要满足，left是bst，right也是bst。并且left和right的depth差不大于1.
         */
        returnNode isBstLeft = isBst(root.left);
        returnNode isBstRight = isBst(root.right);

        if(isBstLeft.isBt && isBstRight.isBt && Math.abs(isBstLeft.depth-isBstRight.depth)<=1){
            //3.应该返回什么：既要返回当前节点是否是bst，也要返回当前节点的depth。
            return new returnNode(Math.max(isBstLeft.depth, isBstRight.depth)+1, true);
        }
        //3.如果不是bst，depth随意。
        return new returnNode(0, false);
    }

    public static void main(String[] args) {
//        ArrayList record = new ArrayList(26);
//        record.toArray();

        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        l0.next=l1;
        l1.next=l2;
        l2.next=l3;
        ListNode swip = swapPairs(l0);
        ListNode cur = swip;

        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }


    }
}
