// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
APPROACH 1: (Taking a prev pointer global to the stack)
Intuition is that inorder is a sorted order.
Saving value of previous root and setting it to reference prev.
Run inorder, if prev value becomes greater than curr, return false.

APPROACH 2: (Using Min and Max for every node)
Comparisons are drawn according to:
1. for left child, min remains same but max is upto root value.
2. for right child, max remains same but min is upto root value.

Whenever the root value is less than minimum or more than maximum we return.
 */

public class ValidateBST {
    public class TreeNode {
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

    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root, null, null);

        //inorder(root);
        //return false;
    }

    //min-max method - recursive
    private boolean inorder(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return true;
        if((min != null && root.val <= min) || ( max!=null && root.val >= max)) return false;

        //logic
        return inorder(root.left, min, root.val) && inorder(root.right, root.val, max);

    }

    //min-max method - iterative
   /* private boolean inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode min = null;
        TreeNode max = null;
        if(root == null) return true;

        while(!stack.isEmpty() || root != null){
            while(root!=null){
                stack.push(root);
                stack.push(max);
                stack.push(min);
                root = root.left;
            }
            min = stack.pop();
            max = stack.pop();
            root = stack.pop();
            if((min != null && root.val <= min.val) || ( max!=null && root.val >= max.val)){
                return false;
            }
            root = root.right;
        }
        return true;
    }*/

    //isValid boolean method - iterative
    /*private boolean inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && (root.val <= prev.val)){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;

    }*/

    //isValid boolean method - recursive
    /*private boolean inorder(TreeNode root){
        //base
        if(root == null) return true;

        if(!inorder(root.left)) return false;

        if(prev != null && root.val <= prev.val){
            return false ; //if we don't return here, we will keep on traversing even when we would've found the discrepancy
        }
        // last root as prev
        prev = root;
        return inorder(root.right);
    }
    */



    // isValid void method
   /* private void inorder(TreeNode root){
        //base
        if(root == null)
            return;

        //logic
        inorder(root.left);

        if(prev != null && root.val <= prev.val){
            isValid = false;
            return; //if we don't return here, we will keep on traversing even when we would've found the discrepancy
        }
        // last root as prev
        prev = root;
        return inorder(root.right);
    } */

    //recursive
    /*private void inorder(TreeNode root){
        if(root == null){
            return root;
        }

        inorder(root.left); //st.pop()
        System.out.println(root.val); //up

        inorder(root.right); // st.pop()
        System.out.println(root.val); //down
    }*/

    //Iterative
    /*private void inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(root != null !! !stack.isEmpty()){
            while(root!= null){
                stack.push(root);
                root = root.left;
            }
            //left recursion finishes then stack.pop
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }*/

}
