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
     int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxsum(root);
        return ans;
    }
    public int maxsum(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(maxsum(root.left),0);
        int right = Math.max(maxsum(root.right),0);
        int sum = root.val+left+right;
        ans=Math.max(ans,sum);
        return root.val+Math.max(left,right);
    }
}