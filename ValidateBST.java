package s30.trees.trees1;

import s30.trees.TreeNode;


// Time Complexity : O(n) as we are traversing all the nodes in worst case.
// Space Complexity: O(h) space for recursive stack, h being the height of the tree. logn <= h <= n;
public class ValidateBST {
    private  long inorderPred = Long.MIN_VALUE ;

    // Concept: Inorder predecessor
    public  boolean isValidBST(TreeNode root) {

        return isValidBSTRec(root);

    }

    private boolean isValidBSTRec(TreeNode root){
        //base
        if(root == null) return true;


        //In order recurse
        //left
        if(!isValidBSTRec(root.left)) return false;

        //process
        if(root.val <= inorderPred)
            return false;
        inorderPred = root.val;


        //right
        boolean right = isValidBSTRec(root.right);

        return right;

    }
    public static void main(String[] args) {
    }
}
