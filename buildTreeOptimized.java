// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    Map<Integer, Integer> inorderMap;
    int preIdx; 
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        
        inorderMap = new HashMap<>();
        
        //we store in hashmap the values with the indexes so it is easier to obtain the index
        for(int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        
        //we will use the helper method to split the arrays each time
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base: we have hit the end of the array
        if(start > end) return null;
        //logic
        
        //root value is the first element in the preorder array
        int rootVal = preorder[preIdx];
        //as soon as we get the first root value, we can increment to the next one
        preIdx++;
        //the new treenode would be the current rootVal
        TreeNode root = new TreeNode(rootVal);
        
        //inorder root idx
        int rootIdx = inorderMap.get(rootVal);
        
        //divide left and right subtrees
        root.left = helper(preorder, inorder, start, rootIdx - 1);
        root.right = helper(preorder, inorder, rootIdx + 1, end);
        
        return root;
    }
}












