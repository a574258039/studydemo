package com.zzg.study.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 *   100. 相同的树
 *   给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 *   如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *  /
 */

public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right , q.right);
    }
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode t1=queue.poll();
            TreeNode t2=queue.poll();
            if(t1!=null&&t2!=null&&t1.val==t2.val){
                queue.offer(t1.left);
                queue.offer(t2.left);
                queue.offer(t1.right);
                queue.offer(t2.right);
            }else if((t1==null&&t2!=null)||(t1!=null&&t2==null)) {
                return false;
            }else if(t1!=null&&t2!=null&&t1.val!=t2.val){
                return false;
            }
        }
        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}