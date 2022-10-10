// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        isValid = true;
        inorder(root);

        return isValid;
    }

    private void inorder(TreeNode root) {
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        //System.out.println("Up");
        //System.out.println(root.val);
        if(prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev=root;
        inorder(root.right);
        //System.out.println("Down");
        //System.out.println(root.val);
    }
}


//With boolean return
// Time Complexity : O(N) where N os number of nodes in tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
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
    //boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        //isValid = true;
        return inorder(root);

        //return isValid;
    }

    private boolean inorder(TreeNode root) {
        //base
        if(root == null) return true;
        //logic
        boolean left = inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            //isValid = false;
            return false;
        }
        prev=root;
        boolean right = inorder(root.right);
        return left&&right;
    }
}

//Iterative
// Time Complexity : O(N) where N os number of nodes in tree
// Space Complexity : O(N) because of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();

        while(root != null || !s.isEmpty()) {
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev!=null && prev.val>=root.val){
                return false;
            }
            prev=root;
            root=root.right;
        }
        return true;
    }
}