import java.util.HashMap;
// Time Complexity: O(n) n = number of elements in the preorder array
// Space complexity: O(n) n = number of elements in the array stored in the hashmap
// Executed on leetcode

// Approach: The root is taken from the first element of preorder array.
// Left and right subtree of the current root is at the start to index-1 of the root
// anfd index+1 to end of the inorder array respectively.

class Solution {
    HashMap<Integer, Integer> map;
    int index=0;
    private TreeNode helper(int[] preorder,int start,int end) {
        //base
        if(start>end || index==preorder.length) return null;
        
        int inIdx = map.get(preorder[index]); //index of the root from the Inorder array to get left and right part of tree
        TreeNode root = new TreeNode(preorder[index]); // starting element of preorder is root
        index++;
        root.left = helper(preorder, start, inIdx-1);
        root.right = helper(preorder,inIdx+1,end);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
    }
}