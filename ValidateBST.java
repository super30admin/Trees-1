// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) recursive stack of n calls in a skewed tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I didnt consider the fact initially that the whole subtree needs to be lesser than root, I was just c
/* Your code here along with comments explaining your approach: Goto the left subtree. Compare each node value in the left with its parent BUT importantly
make sure that we are also comparing the node value with each ancestor (for this we will be maintaining max while we move left) since the ancestor value will be always
be greater than the node value. Similarly, on the right subtree, the node value must be greater than the ancestor ( we are maintaining min while we move right) value to keep
a check for each node value as we reach each of the nodes. Whenever we are moving to left child of right subtree or right child of left subtree, we would be
comparing the node value with max and min (one becomes the parent value depending on the subtree and the other becomes the min/max of ancestors
as the upper/lower bound) to ensure that the node value is satsifying the criteria for each ancestor.
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    private boolean isBST(TreeNode root, Integer max, Integer min ){
        if(root == null){return true;}
        if(max != null && root.val >= max || min != null && root.val <= min){           // Compare the node value with max and min (ancestors and parent)
            return false;
        }
        return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);    // both the subtrees should return true
    }
}