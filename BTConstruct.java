// Optimized Approach : Using Hashmap

class Solution {
    
    // Key : no & value : index
    HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, preorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base case
        if(start > end)
            return null;
        
        //build a node
        int rootVal = preorder[preIndex];
        preIndex++;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        
        //we build left subtree first & the right subteree as preorder is : Root L R
        //build left subtree
        root.left = helper(preorder, inorder, start, rootIdx - 1);
        
        //build right subtree
        root.right = helper(preorder, inorder, rootIdx + 1, end);
        
        return root;
    }
}

//Time Complexity :O(n)
//Space Complexity :O(n)