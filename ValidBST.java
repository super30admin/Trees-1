// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* /* Method 5 - Using limit approach - void function

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
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root, null, null);
        return flag;
    }

    private void helper(TreeNode root, Integer min, Integer max){

        //base case
        if(root == null)
            return;

        if(min != null && root.val <= min)
            flag =  false;

        if(max != null && root.val >= max)
            flag = false;

        //logic
        helper(root.left, min, root.val);

        if(flag)
            helper(root.right , root.val, max);

    }
}
*/
 */

/* Method 4 - Using limit approach - boolean function
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
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){

        //base case
        if(root == null)
            return true;

        if(min != null && root.val <= min)
            return false;

        if(max != null && root.val >= max)
            return false;

        //logic
        boolean left = helper(root.left, min, root.val);

        boolean right = true;
        if(left)
            right = helper(root.right , root.val, max);

        return left && right;
    }
}

*/
/*Method 3 - Using iterative method helper function
TC: O(n) where n is the number of nodes
SC: O(h) where h is the height of the tree

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

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;

        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }

            root = st.pop();

            if(prev != null && prev.val >= root.val)
                return false;

            prev = root;
            root = root.right;
        }
        return true;
    }
}

 */
 /* Method 3  -taking boolean return function
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

class Solution {

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    private boolean inOrder(TreeNode root){
        if(root == null)
            return true;

        boolean left = inOrder(root.left); //st.pop() = root
        //System.out.println("Up");
        //System.out.println(root.val);

        if(prev!=null && prev.val >= root.val){
            return false;
        }

        prev = root;

        boolean right = inOrder(root.right); //st.pop() = root
        //System.out.println("Down");
        //System.out.println(root.val);

        return left && right;
    }
}
 */

*/

/* Method 2- Using pointer prev and boolean flag variable
(Take prev as global instead of local. Local variables are over-written)
 */
/*
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

class Solution {

    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        inOrder(root);
        return flag;
    }
    private void inOrder(TreeNode root){
        if(root == null)
            return;
        if(flag)
            inOrder(root.left); //st.pop() = root
        //System.out.println("Up");
        //System.out.println(root.val);

        if(prev!=null && prev.val >= root.val){
            flag = false;
        }

        prev = root;
        if(flag)
            inOrder(root.right); //st.pop() = root
        //System.out.println("Down");
        //System.out.println(root.val);
    }
}
*/




/* Method 1 - TC: O(n) where n is the number of nodes
SC: O(h) where h is the height of the tree
 */
/*
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

class Solution {
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return true;
    }
    private void inOrder(TreeNode root){
        if(root == null)
            return;

        inOrder(root.left); //st.pop() = root
        System.out.println("Up");
        System.out.println(root.val);

        inOrder(root.right); //st.pop() = root
        System.out.println("Down");
        System.out.println(root.val);
    }
}
*/