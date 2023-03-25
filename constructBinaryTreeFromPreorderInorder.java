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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0) return null;
        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);

        int rootIdx = -1;

        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == rootval){
                rootIdx = i;
                break;
            }
        }

        int[] InLeft = Arrays.copyOfRange(inorder,0,rootIdx);
        int[] InRight = Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        int[] PreLeft = Arrays.copyOfRange(preorder,1,1+InLeft.length);
        int[] PreRight = Arrays.copyOfRange(preorder,1+InLeft.length,preorder.length);
        root.left = buildTree(PreLeft, InLeft);
        root.right = buildTree(PreRight, InRight);
        return root;


    }
}



/*** 

Explanation : 

-> If we have given only one traversal. we cant build a specific tree from it. Because we can form different trees by using one traversal. So, Inorder and Preorder can tell us exactly what we can have at left & right.

-> From Preorder we can find the Root & from Inorder we can find the left side of the root.

-> So, the left of Inorder will be the left of Preorder. We can know by number of nodes.

-> For every recursive call we are searching Root value in Inoder Traversal and by this rootIndex we can copy inLeft, inRight & preLeft, preRight inside each array.




TC: O(n^2) - O(n) In each recursive call for searching its O(n), each recursive for splitting and creating array the TC will be O(n). There are n number of recursive calls. So total its O(n^2).


SC: O(n^2) Creating Space for Array.

 
*/
