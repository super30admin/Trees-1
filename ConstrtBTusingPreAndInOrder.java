// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class ConstrtBTusingPreAndInOrder {
    public class TreeNode {
             int val;
    TreeNode left;
    TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
          this.left = left;
         this.right = right;
     }
 }
    HashMap<Integer,Integer> myMap;
    int index =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        myMap = new HashMap<>();
        //construct the map
        for(int i=0; i<inorder.length; i++){
            myMap.put(inorder[i],i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base
        if(index == preorder.length || start >end){
            return null;
        }

        int rootVal = preorder[index];
        int rootIndex = myMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        index++;

        root.left = helper(preorder,inorder, start, rootIndex-1);
        root.right = helper(preorder,inorder, rootIndex+1,end);
        return root;
    }
}
