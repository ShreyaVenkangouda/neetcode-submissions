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
    public int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        int leftCount = countNodes(root.left);
        if(leftCount >= k){
            return kthSmallest(root.left,k);
        }
        else if(leftCount == k-1){
            return root.val;
        }
        else{
            k = k - leftCount -1;
            return kthSmallest(root.right,k);
        }
    }
}
