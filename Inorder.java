
/*
Time Complexity :  O(n) where finding the index is O(n).
Space Complexity: O(n) as I am using Hashmap to store the elements.
Worked on leetcode.
*/
import java.util.*;

class Solution {
    
    HashMap<Integer,Integer> map;
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0 || preorder == null) {
            
            return null;
        }
        
        map = new HashMap<>();
        
        for(int i  = 0; i<inorder.length;i++) {
            
            map.put(inorder[i], i);
            
        }
        
       return  helper(preorder, 0, inorder.length-1);
        
        
    }
    
    private TreeNode helper(int[]preorder, int start, int end) {
        
        if(start>end) {
            return null;
        }
       
        int rootval = preorder[idx];
        int rootIdx =  map.get(rootval);
        idx++;
        TreeNode root = new TreeNode(rootval);
        
        root.left = helper(preorder,start,rootIdx -1);
        root.right = helper(preorder, rootIdx +1, end);
        
        
        return root;
        
        
    }
    
    
}