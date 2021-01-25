// Time Complexity : O(n)
// Space Complexity : O(n)

// Your code here along with comments explaining your approach
// use preorder traversal to find root, then left and right halves of this node can be found from inorder
// since preorder is root,left,right, next can form node (root) in left half
//call helper() on left half then right half

class Solution {
    int preIdx;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0)
            return null;
        
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        
        return helper(0, inorder.length-1, preorder, inorderMap);
    }
    
    private TreeNode helper(int low, int high, int[] preorder, HashMap<Integer, Integer> inorderMap){
        if(low>high)
            return null;
        
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int idx = inorderMap.get(rootVal);
        
        root.left = helper(low, idx-1, preorder, inorderMap);
        root.right = helper(idx+1, high, preorder, inorderMap);
        
        return root;
    }
}