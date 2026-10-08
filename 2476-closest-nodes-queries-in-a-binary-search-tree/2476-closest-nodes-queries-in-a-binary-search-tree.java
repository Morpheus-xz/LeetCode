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
    List<Integer> arr = new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int x: queries){
            int l=0;
            int r = arr.size()-1;
            while(l<=r){
                int mid = l+(r-l)/2;
                if(arr.get(mid)==x){
                    l=mid;
                    r=mid;
                    break;
                }
                else if(arr.get(mid)<x){
                    l=mid+1;
                }
                else r = mid-1;
            }
            int min=-1;
            int max=-1;
            if(r>=0) min=arr.get(r);
            if(l<arr.size()) max=arr.get(l);
            ans.add(Arrays.asList(min,max));
            
        }
        return ans;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
}