/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Iterative Approach

class Solution {

    //Time Complexity: 0(n) Where n is the nodes in the tree
    //Space Complexity: 0(h) Where h is the height of the BST
    //Did it successfully run on leetcode : Yes
    //Did you face any problem while coding : No

    //In short explain your approach : I took a stack to store the nodes of the tree and a previous node to store the previous
    //node traversed in the tree to check if it is smaller than the current node or not. I am unsing an inorder traversal,
    //where I am traversing the left half of the tree first and then adding them onto stack until null is not encountered.
    //Then I am popping the top of my stack and checking if it is bigger than the previous value or not. If it is then my
    //if condition is not hit and if it's not Then I return False. Similarly when the traversal of left tree is completed, I
    //traverse through the right tree. Also I am changing my value of prev to root once the condition is checked and then
    //the root jumps onto new value.

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> s = new Stack <>();
        boolean status = true;
        TreeNode prev = null;
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return status;
    }
}

//Recursive Approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    boolean status;
    public boolean isValidBST(TreeNode root) {
        status = true;
        helper(root);
        return status;
    }
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        if( prev != null && prev.val >= root.val){
            status = false;
            return;
        }
        prev = root;
        helper(root.right);
    }
}

//Min And Max Approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);
        if(min != null && root.val <= min){
            return false;
        }
        if(max != null && root.val >= max){
            return false;
        }
        return left && right;
    }
}