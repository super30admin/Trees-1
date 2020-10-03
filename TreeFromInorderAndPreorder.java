// I wasn't very clear about how to calculate the TC using the master theorem here
// Time Complexity : O(n), we would process and build one root node at a time 
// Space Complexity : O(n) + O(log n) for (preorder, inorder, hashmap) + for call stack 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// This was hard, I did not get the intuition to solve the problem, I was trying to make the tree by traversing the array in reverse given right would be the rightmost element
// and build the tree from there but that did not take in all test cases, didn't work
//I saw the solution on leetcode and drew the recursion tree to understand it and practiced coding it 

// Your code here along with comments explaining your approach
// This solution makes use of the idea that preorder contains the root as the 1st element
// it then looks up the same element in the inorder traversal to divide into left half and right half
// increment onto next element in the preorder array as root is assigned 
// call the helper fn on left half and right half 

class Solution {
    int[] preorder;
    int[] inorder;
    int pre_idx;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>(); 
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        
        for(int i=0; i<inorder.length;i++){
            idx_map.put(inorder[i], i);
        }
        
        return helper(0, inorder.length);    
    }
    
    private TreeNode helper(int in_left,int in_right){
        if(in_left==in_right)
            return null;
        
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        pre_idx++;
        
        int index = idx_map.get(root_val);
        
        root.left = helper(in_left, index);
        root.right = helper(index+1, in_right);
        return root;
    }
}