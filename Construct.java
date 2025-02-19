// Overall Time Complexity : O(n^2) . The time taken due  to linear searches and copying in each recursive call.
// Overall Space Complexity : O(n^2) . The space complexity is 0(n) because  to repeated subarray copying and the recursion stack.
// Any problem you faced while coding this : No issues faced during implementation



import java.util.Arrays;

import javax.swing.tree.TreeNode;

public class Construct {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder);
    }
    private TreeNode helper ( int [] preorder, int[] inorder){
        if (preorder.length == 0){
            return null;
        }
        // root node
        int rootValue = preorder[0];
        TreeNode root =  new TreeNode(rootValue);
        int rootIndex = -1;
        //find the root in inorder to get the left subtree and right subtree

        for(int i = 0 ; i<inorder.length; i++){
            if(root.val== inorder[i]){
                rootIndex = i;
                break;
            }
        }

        //Mark the left subtree and right subtree in the  inorder and post order 
        int [] inorder_left = Arrays.copyOfRange(inorder, 0, rootIndex);
        int [] inorder_right = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int [] predorder_left = Arrays.copyOfRange(preorder, 1, 1+inorder_left.length);
        int [] preorder_right = Arrays.copyOfRange(preorder, 1+inorder_left.length, preorder.length);

        // recursively traverse left and right subtrees
        root.left = helper(predorder_left, inorder_left);
        root.right = helper(preorder_right, inorder_right);

        return root;
}

}
