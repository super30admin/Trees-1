// Time Complexity : O(n pow 2)
// Space Complexity : O(n pow 2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -


import java.util.Arrays;

// Use PreOrder to know the root(1st num) identify its position in InOrder and mark InLeft and InRight
//Count num of elements in InLeft and InRight and traverse PreOrder to mark PreLeft and PreRight arrays
//Repeat the process recursively to build the complete tree, return root
public class BuildTreeFromInPre {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //base case
        if(preorder.length == 0) return null;

        //logic
        int rootVal = preorder[0];
        int rootIdx = -1;//root index in inorder, which needs to be found
        //Iterate through Inorder to find root index
        for(int i=0; i< inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder,0,rootIdx);//(src,startIndex(inclusive), endIndex(exclusive))
        int[] inRight = Arrays.copyOfRange(inorder,rootIdx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder,1,inLeft.length+1);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);//inLeft+1 because we are leaving 1st element which is root in preorder

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}
