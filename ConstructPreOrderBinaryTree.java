Time complexity: O(n*n) : n of elements and another n is time taken to copy the elements from one array to another.
Space complexity:O(n*n): For each and every element we are creating new array. For n elements multipled by n.
Approach: Pre order: root-left-right, In order: left-root-right 
Step1: Identify the root element in pre order array. Traverse the inorder array to find the left and right array. 
	   Get the index when the preorder root element is found in inorder array.
Step2: Copy the elements to inorderLeft, copy from 0 to index; note than end pointer is always 1 less(Ex: if value is 4 then it copies until index 3)
	   inorderRight=(index+1, inorder.length)
	   preOrderLeft=(1, inorderleft.length+1)
	   preOrderRight=(inorderLeft.length+1, preOrder.length)
Step3: Keep traversing for left and right elements. If either of arrays become empty return 

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
        //base case
        if(preorder.length==0) return null;
        
        //logic
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                index = i;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder,1,inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder,inLeft.length+1,preorder.length);
        
        root.left=buildTree(preLeft,inLeft);
        
        root.right=buildTree(preRight,inRight);

        return root;

    }
}
