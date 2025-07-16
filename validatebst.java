//Time Complexity: O(n) — Each node is visited once during in-order traversal.
//Space Complexity: O(h) — Stack space used, where h is the height of the tree (worst case O(n) for skewed tree, O(log n) for balanced).

//Perform iterative in-order traversal using a stack.
//Keep track of the previous node; for a valid BST, each current node must be greater than the previous.
//If any node violates the BST rule (prev.val >= current.val), return false; otherwise, return true after traversal.

class Solution {
    public boolean isValidBST(TreeNode root) {

        TreeNode prev = null;

        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            if(prev != null && prev.val >= root.val){
                return false;
            }

            prev = root;
            root = root.right;
        }

        return true;
    }
}
