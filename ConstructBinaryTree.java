import java.util.HashMap;

import javax.swing.tree.TreeNode;

//Time Complexity: O(m + n)
//Space Complexity: O(n)

//we have two arrays, one representing the preorder traversal and the other representing the inorder traversal of the binary tree
//preorder is traversing root->left->right through the binary tree
//inorder is traversing left->root->right through the binary tree
//therefore, preorder will always provides us with the root of any subtree
//whereas the inorder array provides us with the left and right subtrees at any point
//Example: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

class Solution {
    
    //creating a hashmap to store the values and their index in the inorder array
    HashMap<Integer, Integer> map;
    
    int idx; 
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //checking if the tree is empty
        if(preorder.length == 0) return null;
        
        //initializing the hashmap
        map = new HashMap<>();
        
        //adding all the elements from the inorder array and their indexes
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        //call the recursive function 
        return helper(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int [] preorder, int start, int end) {
        
        //base
        if(start > end) return null;
        
        //logic
        //storing the value at the root
        int rootVal = preorder[idx];
        idx++;//moving forward in the 
        
        //getting the inorder indexes of the root value
        int rootIdx = map.get(rootVal);
        
        //initializing the root as the current root value
        TreeNode root = new TreeNode(rootVal);
        
        //get the left subtree of the root
        root.left = helper(preorder, start, rootIdx - 1);
        
        //get the right subtree of the root
        root.right = helper(preorder, rootIdx + 1, end);
        
        return root;
    }
    
}