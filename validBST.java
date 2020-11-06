import com.sun.source.tree.Tree;

import java.util.Stack;

//https://leetcode.com/problems/validate-binary-search-tree/

// Your code here along with comments explaining your approach
public class validBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    // using inorder traversal and iterative approach
    // Time Complexity :O(n) -> number of elements
    // Space Complexity :O(n) -> for using stack
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    //
    // Your code here along with comments explaining your approach
    // 1. push all elements from root till left most element . Now this element is lowest element , if this element is less than minimum(which  is
    // negative infinity initially ) then return false since this should be the lowest element. Now pop this element and update minimum to this value
    // and check if it has a right subtree.
    // 2.  If there is no sub tree then pop the next element in stack and check if it is less than  minimum ,
    // 3 . If it has a right subtree then push the right element into stack and update minimum to the current element. Repeat above steps in order
    //  till all elements are covered or till bst is not valid.
    public boolean isValidBST(TreeNode root) {
        if(root == null)    return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode min = null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(min!=null &&  root.val <= min.val) return false;
            min = root ;
            root = root.right;
        }
        return true;
    }
    
    //using recursive approach
    // Time Complexity :O(n) -> number of elements
    // Space Complexity :O(n) 
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    //
    // Your code here along with comments explaining your approach
    // 1. A BST is valid if all subtrees are valid subtrees . So here, we recursively check if both left and right subtrees
    //  are valid subtrees .
    // 2. for the root element the lower and upper limits will be null , for elements left to the root upper value will be limited to root value
    //  and for elements  right to the root or the right subtree of the root , lower will be limited to root value.
    // 3. Root value will be updated for each subtree and similarly the upper and lower limits will be adjusted accordingly.
    public boolean isValidBST2(TreeNode root){
        if(root == null)    return true;
        return helper(root,null,null);
    }

    public boolean helper(TreeNode root,Integer low,Integer high){
        //base condition
        if(root == null)
            return true;
        if(low != null && root.val<=low) return false;
        if(high!= null && root.val>=high) return false;
        // checking for left sub tree and right sub tree
        return (helper(root.left,low,root.val) && helper(root.right,root.val,high));
    }

    public static void main(String[] args) {
        TreeNode input = new TreeNode(3);
        input.left = new TreeNode(1);
        input.right = new TreeNode(5);
        input.left.left = new TreeNode(0);
        input.left.right = new TreeNode(2);
        input.right.left = new TreeNode(4);
        input.right.right = new TreeNode(6);
        input.left.right.right = new TreeNode(3);
        validBST obj = new validBST();
        System.out.print(obj.isValidBST(input));
    }
}
