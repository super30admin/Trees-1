// Time Complexity : O(n^2)), 
// Space Complexity : O(n^2),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
import java.util.*;
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       //check if preorder is empty
        if(preorder.length == 0) return null;
        int rootVal = preorder[0];
        int rootIdx = 0;
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
            }
        }
        int [] preLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int [] preRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);
        int [] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int [] inRight = Arrays.copyOfRange(inorder,rootIdx + 1, inorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);    
        return root;
    }   
}
