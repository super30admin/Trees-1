/* TC: O (n) where n is the number of nodes in the resulting tree
 * SC: O (h) where h is the height of the tree (recursive stack space)
 *
 * Approach - for each node, it's value would be the max possible for it's left node,
 * and the min possible for it's right node. Propagate these max and min values recursively
 * (starting with infinities or nulls) and check for validity at each node.
 */
public class ValidateBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
     * Helper function to recursively check whether a node
     * and its children are within bounds [min, max]
     */
    boolean isValidBSTNode(TreeNode node, Integer min, Integer max) {
        // empty trees are always valid
        if (node == null) return true;

        // if the bounds are supplied and the
        // node is out of bounds, return false
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // check left with max bound = curr node's value
        // and right with min bound = curr node's value
        return isValidBSTNode(node.left, min, node.val) && isValidBSTNode(node.right, node.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        // call the bounds function with root
        // and no bounds initially
        return isValidBSTNode(root, null, null);
    }
}
