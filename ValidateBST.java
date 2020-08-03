class ValidateBST{
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);

    }

    public boolean helper(TreeNode node, int lower, int upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }
    //time complexity : o(n) -> where n is number of nodes
// space complexity : maximum depth of tree
//Approach : In order traversal using recurssion. go to left most element and start comparing left element < root < right element.
}