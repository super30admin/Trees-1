//solution 1 using recursion

// Definition for a binary tree node.
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    private long inorderPrev;
    public boolean isValidBST(TreeNode root) {
        inorderPrev = Long.MIN_VALUE;
        
        return recursiveBST(root);
    }
    
    public boolean recursiveBST(TreeNode node){
        if(node == null){
            return true;
        }
        
        //left
        if (!(recursiveBST(node.left))){
            return false;
        }
        
        //current
        if(node.val <= inorderPrev){
            return false;
        }
        inorderPrev = node.val;
        
        //right
        return recursiveBST(node.right);
        
    }
    
}

//Solution 2 using stack
public class problem1_validate_BST {
    public boolean isValidBST(TreeNode root) {
        long inorderPrev = Long.MIN_VALUE;
        
        Stack<TreeNode> stck = new Stack<>();
        
        while(root != null){
            stck.push(root);
            root = root.left;
        }
        
        while(!stck.isEmpty()){
            TreeNode node = stck.pop();
            
            //current
            if(node.val <= inorderPrev){
                return false;
            }
            inorderPrev = node.val;
            
            //right
            node = node.right;
            
            //left
            while(node != null){
                stck.push(node);
                node = node.left;
            }
        }
        return true;
    }
}