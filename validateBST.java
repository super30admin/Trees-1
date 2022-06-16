// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class TreeNode {

    // class for constructing treeNode
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

class Main {
    // global variables
    static TreeNode root;
    static TreeNode prev;
    static boolean flag;

    public static boolean isValidBST(TreeNode root) {
        // helper function
        inOrder1(root);
        return !flag;

        // return inOrder2(root);
    }

    // approch 1
    private static void inOrder1(TreeNode root) {

        // base case
        if (root == null)
            return;
        // logic
        // inorder traversal
        // first traverese through left side of the tree
        inOrder1(root.left);
        // recursive stack.pop()

        // here we check if previous value is greater than root value or not if yes we
        // make a flag true that tree is not valie
        if (prev != null && prev.val >= root.val) {
            flag = true;
        }

        // make current root as previous
        prev = root;
        // if flag is true then we do not have traverse in right sub tree
        if (!flag)
            inOrder1(root.right);
    }

    // approch 2
    private static boolean inOrder2(TreeNode root) {

        // base case
        if (root == null)
            return true;
        // logic
        // if left subtree is already false then we return false we do not need to
        // traverse in right sub tree
        if (!inOrder2(root.left))
            return false;

        // here we check if previous value is greater than root value or not if yes we
        // return false
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        // here if got true from the left subtree our right sub tree will be deciding
        // factor that tree is valis BST or not.
        return inOrder2(root.right);
    }

    // to constructing binary Tree
    private static TreeNode addRecursive(TreeNode current, int val) {
        if (current == null) {
            return new TreeNode(val);
        }

        if (val < current.val) {
            current.left = addRecursive(current.left, val);
        } else if (val > current.val) {
            current.right = addRecursive(current.right, val);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public static void add(int val) {
        root = addRecursive(root, val);
    }

    public static void main(String[] args) {
        add(25);
        add(20);
        add(30);
        add(15);
        add(23);
        add(14);
        add(16);
        add(21);
        add(24);
        add(27);
        add(35);
        add(26);
        add(29);
        add(33);
        add(40);
        System.out.println(isValidBST(root));
        // intialize the root node

    }

}