package com.zzg.study.algorithm;

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
}