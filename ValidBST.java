// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Inorder traversal of a BST gives a sorted array. Perform inorder and check each element with previou element to see if it is greater
If the previous element is greater - array is not serted - return false
If not - array is sorted - return true
*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        for (int i = 1; i < res.size(); i++) {
            System.out.print(res.get(i - 1) + " ");
            if (res.get(i - 1) >= res.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);

    }
}


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



// Your code here along with comments explaining your approach

/* Using similar methodology to keep track of the previous element using a Node without storing them in a list
*/

class Solution {
    boolean flag;
    TreeNode p;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return this.flag;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (p != null && p.val >= root.val) {
            this.flag = false;
        }
        p = root;
        helper(root.right);

    }
}