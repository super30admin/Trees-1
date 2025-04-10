// Time complexity:- O(n)
// Space complexity:- O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach: 
/**
 * The problem is about verifying if a given binary tree is a valid Binary Search Tree (BST), where left children must be smaller and right children must be greater than the node.  
 * I used an inorder traversal because it should produce a strictly increasing sequence for a valid BST, which can be checked by comparing adjacent values.  
 * I stored the inorder result in a list and returned false if any element was not less than the next; otherwise, the tree is valid.
 */
 
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // Perform inorder traversal and store values in list
        helper(root,list);

         // Check if the inorder list is strictly increasing
        for(int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size()) {
                if (list.get(i) >= list.get(i + 1)) {
                    return false; 
                }
            }
        }
        return true;
    }
    public void helper(TreeNode node, List<Integer> list) {
        //base condition
        if(node == null) {
            return;
        }
        //recurse
        helper(node.left,list);
        //process
        list.add(node.val);
        //recurse
        helper(node.right,list);
    }
}

   

     