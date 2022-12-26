public class ValidateBST {
//https://leetcode.com/problems/validate-binary-search-tree/description/
    /*
    * Binary Tree - tree with no more than 2 sub nodes or children at each level
    * Binary Search Tree - BT with left child less than root and right child greater than root, recursively
    * true for all subsequent nodes.
    * Traversal DFS -  L Root R   R Root L - Inorder    root in mid   - most popular
    *                  Root L R   Root R L - preorder   root as primary
    *                  L R Root   R L Root - postorder  root at end
    *Recursive & Iterative approach
    * Iterative - take a stack, check root's value if it is not null or stack is not empty
    * check for root's value if not null  push root in stack and traverse to left node
    * once root is null pop value from stack print val and traverse to right node
    *
    * TC - O(n) - number of nodes in tree
    * SC - O(h) - height of the tree
    * Inorder traversal should be sorted in ascending order will give valid bst
    * you can store the traversal in list of integers and check whether the prev element is smaller than current
    * TC - O(n) - number of nodes in tree
    * SC - O(n) - as the storage of nodes will take extra space
    * Optimized approach
    * Keep a pointer that points to prev node no need to save
    *
    * Recursion
    * Use recursive stack (hidden/ imaginary)
    *Recursively call inorder method and pass the root value first for left node once found null
    * the root will be checked with prev node
    * save prev and call inorder for right side
    * * TC - O(n) - number of nodes in tree
    * SC - O(h) - height of the tree
    * */

 //Another Recursive Approach - not defining global scope

    public boolean isValidBST(TreeNode root){
        if(root == null) return true;
        return isBinarySeachTree(null, root,null);

    }

    private boolean isBinarySeachTree(Integer min, TreeNode root, Integer max) {
        if(root == null) return true;
        if(min!=null && min>=root.val) return false;
        if(max!=null && max<=root.val) return false;
        boolean case1 = isBinarySeachTree(min,root.left,root.val);
        boolean case2 = isBinarySeachTree(root.val,root.right,max);
        return case1&&case2;

    }


//Recursive Approach
    /*
    TreeNode prev;
    boolean isBST;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        isBST = true;
        inorder(root);
        return isBST;
    }
    private void inorder(TreeNode root){
        if(root == null ) return;
        inorder(root.left);

        if(prev!=null && prev.val>=root.val) {
            isBST = false;
            return;
        }
        prev = root;
        inorder(root.right);

    }*/
    //Iterative
/*
    public static boolean isValidBST(TreeNode root) {

        if(root== null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root!=null || (!st.isEmpty())){
            while(root!=null){
                st.push(root);
                root= root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val>=root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
*/
}
