/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int countGoodNodes(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.val >= max){
            count++;
        }
        int newMax = Math.max(max,root.val);
        count += countGoodNodes(root.left,newMax);
        count += countGoodNodes(root.right,newMax);
        return count;
    }
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root,Integer.MIN_VALUE);
    }
}
