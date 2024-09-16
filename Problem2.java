// TC: O(N) Every time we call the build function
// the number of elements are decreasing as we are slicing
// the tree
// SC: O(N) (Asymptotically it will be O(N))

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // valid tree with null as it's root
        if(preorder == null || preorder.length == 0) return null;
        
        // First value in preorder traversal is 
        // the root node
        TreeNode root = new TreeNode(preorder[0]);
        
        int index = -1;
        
        // iterating over the inorder traversal array
        for(int i = 0; i < inorder.length; i++) {
            
            if(inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        
        // preorder of left
        // left subtree lies in the range of 1 to index + 1 (found above)
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        
        // right subtree
        // exclusive of index + 1 so it goes until index
        int[] preRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        
        // Inorder 
        // left subtree
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        
        // right subtree
        int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        
        // now I have broken my tree so go to the new broken left and right part 
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}