//TC: O(N) - N elements in the tree. for valid bst, we traverse through all elements.
//SC: O(N) - N element in the recursion stack

//We follow recursive approach to validate bst. The whole tree is BST only if all the left and right subtrees are valid.
//The tree is not valid if element to the left of node is greater than node or element to the right is lesser than node.

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

class BST{
    public static boolean isValidBST(TreeNode root){
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode node, Integer low, Integer high){

    //Base Case
    if(node == null) return true;

    //Logic
    if( (low != null && low >= node.val) || (high != null && high <= node.val)) return false;

    return isValid(node.left, low, node.val) && isValid(node.right, node.val, high);
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(16);
        root.right = new TreeNode(25);
        root.left.right = new TreeNode(22);

        System.out.println(isValidBST(root));
    }
}