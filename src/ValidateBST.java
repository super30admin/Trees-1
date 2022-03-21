// Time Complexity:           O(n)
// Space Complexity:          O(h)
// where n is number of nodes in tree, h is height of the tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
  }
}

class ValidateBST {

    private long preVal;

    public boolean isValidBST(TreeNode root) {
        preVal = Long.MIN_VALUE;

        return validateBST(root);
    }

    private boolean validateBST(TreeNode root) {
        if(root == null)
            return true;

        // Left sub tree
        boolean isLeftValid = validateBST(root.left);

        if(isLeftValid) {
            // checking val is valid or not
            boolean isNodeValid = root.val > preVal;
            preVal = root.val;

            if(isNodeValid) {
                // Right sub tree
                boolean isRightValid = validateBST(root.right);
                return isRightValid;
            }
        }

        return false;
    }
}

// ****************************** Another Approach ******************************
//class ValidateBST {
//
//    private long preVal;
//    private boolean isValidBST;
//
//    public boolean isValidBST(TreeNode root) {
//        preVal = Long.MIN_VALUE;
//        isValidBST = true;
//
//        validateTree(root);
//
//        return isValidBST;
//    }
//
//    private void validateTree(TreeNode root) {
//        if(root == null || !isValidBST)
//            return;
//
//        // Left sub tree
//        validateTree(root.left);
//
//        // checking BST valid or not
//        if(root.val <= preVal)
//            isValidBST = false;
//        preVal = root.val;
//
//        // Right sub tree
//        validateTree(root.right);
//
//    }
//}

// ****************************** Another Approach ******************************
//class ValidateBST {
//
//    private long preVal;
//
//    public boolean isValidBST(TreeNode root) {
//        TreeNode prev = null;
//        Stack<TreeNode> stack = new Stack<>();
//
//        while(root != null) {                           // traversing left children chain of that node
//            stack.push(root);
//            root = root.left;
//        }
//
//        while(!stack.isEmpty()) {
//            root = stack.pop();
//
//            if(prev != null && prev.val >= root.val) {  // invalid node
//                return false;
//            }
//
//            prev = root;                                // making current node to prev
//            root = root.right;                          // right child
//
//            while(root != null) {                       // traversing left children chain of that node
//                stack.push(root);
//                root = root.left;
//            }
//        }
//        return true;
//    }
//}


// ****************************** Another Approach ******************************
//class ValidateBST {
//
//    private long preVal;
//
//    public boolean isValidBST(TreeNode root) {
//        TreeNode prev = null;
//        Stack<TreeNode> stack = new Stack<>();
//
//        while(root != null || !stack.isEmpty()) {
//
//            while(root != null) {                       // traversing left children chain of that node
//                stack.push(root);
//                root = root.left;
//            }
//
//            root = stack.pop();
//
//            if(prev != null && prev.val >= root.val) {  // invalid node
//                return false;
//            }
//
//            prev = root;                                // making current node to prev
//            root = root.right;                          // right child
//        }
//        return true;
//    }
//}

// ****************************** Another Approach ******************************
//class ValidateBST {
//
//    private long preVal;
//
//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, null, null);
//    }
//    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
//
//        // if node is null
//        if(node == null) {
//            return true;
//        }
//
//        // node falling in invalid range
//        if((min != null && node.val <= min) || (max != null && node.val >= max)) {
//            return false;
//        }
//
//        // checking for children
//        return isValidBST(node.left, min, node.val)
//                && isValidBST(node.right, node.val, max);
//    }
//}