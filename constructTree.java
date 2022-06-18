//Time Complexity: O(n)
//Space Complexity : O(n);
import java.util.*;
class Solution {
    HashMap<Integer, Integer> hm;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
           return null;
        }
         hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(preorder, 0, inorder.length-1);
        
    }
    private TreeNode helper(int[] preorder, int start, int end){
        if(start>end){
            return null;
        }
        int rootval = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootval);
        int rootIndex = hm.get(rootval);
        root.left = helper(preorder, start, rootIndex-1);
        root.right = helper(preorder, rootIndex+1, end);
        return root;
    }
}