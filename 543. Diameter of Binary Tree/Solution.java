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
    public int maxDiameter = 0;

    public int search(TreeNode node){
        if(node == null) return 0;
        
        int left = search(node.left);
        int right = search(node.right);

        maxDiameter = Math.max(left+right, maxDiameter);

        return 1 + Math.max(left,right);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        search(root);

        return maxDiameter;
    }
}