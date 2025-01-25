import javax.swing.tree.TreeNode;

public /**
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
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length ==0){
            return null;
        }    
            return buildTree (preorder, inorder, 0, preorder.length-1,0 , inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        if (leftStart > leftEnd){
            return null;
        }
        if (rightStart >rightEnd){
            return null;
        }

        TreeNode head = new TreeNode(preorder[leftStart]);
        // find preorder[0] in inorder
        int inOrderPos = -1;
        for (int i =rightStart;i <= rightEnd;i++){
            if (inorder[i] == preorder[leftStart])
            {
                inOrderPos = i; break;
            }
        }
        // int[] leftPre = Arrays.copyOfRange(preorder,1,1+inOrderPos);
        // int[] leftIn = Arrays.copyOfRange(inorder,0,inOrderPos);

        //  int[] rightPre = Arrays.copyOfRange(preorder,inOrderPos +1,preorder.length);
        // int[] rightIn = Arrays.copyOfRange(inorder,inOrderPos+1,inorder.length);

        int leftSubtreeSize = inOrderPos - rightStart;
        head.left = buildTree(preorder,inorder,
        leftStart+1,
        leftSubtreeSize+ leftStart,
        rightStart,
        inOrderPos-1);
        head.right = buildTree(preorder,inorder,
        leftStart +leftSubtreeSize+1,
        leftEnd,
        inOrderPos+1,
        rightEnd);

       return head; 

    }
} {
    
}
