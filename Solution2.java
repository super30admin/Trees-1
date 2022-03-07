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
/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] preo, int psi, int pei, int[] ino, int isi, int iei){
        if(psi > pei || isi > iei){
            return null;
        }    
        
        TreeNode node = new TreeNode(preo[psi]);
        int sidx = -1;
        for(int i=isi; i<=iei; i++){
            if(ino[i]==preo[psi]){
                sidx = i;
                break;
            }
        }
        
        int cle = sidx - isi;
        node.left = helper(preo, psi + 1, psi + cle, ino, isi, isi + cle - 1);
        node.right = helper(preo, psi + cle + 1, pei, ino, isi + cle + 1, iei);
        return node;
    }
}
