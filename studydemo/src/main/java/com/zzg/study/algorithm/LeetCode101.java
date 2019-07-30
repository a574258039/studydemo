package com.zzg.study.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * 1.用递归的方式
     * @param t1
     * @param t2
     * @return
     */
    public boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if ((t1 != null && t2 == null) || (t1 == null && t2 != null)) {
            return false;
        }
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1.val == t2.val) {
            return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
        }
        return false;
    }

    /**
     * 2.用队列广度优先迭代
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode t1=queue.poll();
            TreeNode t2=queue.poll();
            if ((t1 != null && t2 == null) || (t1 == null && t2 != null)) {
                return false;
            }
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1.val == t2.val) {
                queue.offer(t1.left);
                queue.offer(t2.right);
                queue.offer(t1.right);
                queue.offer(t2.left);
            }else {
                return false;
            }
        }
        return true;
    }
}