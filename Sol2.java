//Construct Binary Tree from Preorder and Inorder Traversal
/** 3 Pointer Approach: 
    1.  preorder traversal follows Root -> Left -> Right and will provie the ROOTs
    2.  The first element in the preorder list is a  and This root splits inorder list into left and right subtrees.
    3.  keep poping roots from Preorder and keep dividing Inorder into L and R
 */  
//
//time Complexity :
// O(N)

// Space Complexity :
// O(N)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO.

public class Sol2 {
 
    Map<Integer, Integer> map = new HashMap();
    int idx = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
               
        for(int i=0; i< inorder.length; i++){            
            map.put(inorder[i], i);
        }       
        
        return helper(preorder, inorder, 0, inorder.length);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        
        //base 
        if(idx  == preorder.length || start>end) return null;
  
        //logic
        //find rootIdx in inorder traversal
        int rootIdx = map.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx]);
        idx++; // next root

        root.left = helper(preorder, inorder, start, rootIdx-1);
        root.right = helper(preorder, inorder, rootIdx+1, end);
        
        return root;  
    }

}