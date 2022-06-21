//Time Complexity: O(n)
//Space Complexity: O(h), h is the height of the tree
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root, null , null);
        return flag;        
    }
    private void helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return;
        if(min != null && root.val <= min){
            flag = false;
        }
        if(max != null && root.val >= max) {
            flag = false;
        }
        //logic
        helper(root.left, min, root.val);
        helper(root.right, root.val, max);
 
    }
}
/*10
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return helper(root, null , null);
        
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        //logic
        boolean left = helper(root.left, min, root.val);
        //st.pop();
        boolean right = true;
        if(left)
            right = helper(root.right, root.val, max);
        return left && right;
        
    }
*/
/* 9 optimal of bellow code
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return helper(root, null , null);
        
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        //logic
        boolean left = helper(root.left, min, root.val);
        //st.pop();
        boolean right = true;
        if(left)
             right = helper(root.right, root.val, max);
        return left && right;
        
    }
*/
/* 8using return type boolean and a diff function
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return helper(root, null , null);
        
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        //logic
        boolean left = helper(root.left, min, root.val);
        //st.pop();
        
      
        boolean right = helper(root.right, root.val, max);
        return left && right;
        
    }
   
}*/

/*7 Iterative solution 
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root != null || !st.isEmpty()){
            //inorder(root.left)
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
   
}
*/

/*
//6 using return type boolean 
// we are compairing left if false no need to check right
class Solution {
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        return inorder(root,null);
    }
    private boolean inorder(TreeNode root){
        //base
        if(root == null) return true;
        //
        boolean left = inorder(root.left);
        //st.pop()
        if(left == false) return false 
        if(prev != null && prev.val >= root.val)
            return false;
        //
        prev = root;
        //boolean right = true;
        //if(left)
        //   right = inorder(root.right);
        //st.pop()
        return inorder(root.right);
        //return left && right;
       
        
    }
}
*/
    
/*5 using return type boolean 
// we are compairing it with right here
class Solution {
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        return inorder(root,null);
    }
    private boolean inorder(TreeNode root){
        //base
        if(root == null) return true;
        //
        boolean left = inorder(root.left);
        //st.pop()
        //if(left == false) return false //we don't need as we are coparing it in return statement
        if(prev != null && prev.val >= root.val)
            return false;
        //
        prev = root;
        boolean right = true;
        if(left)
            right = inorder(root.right);
        //st.pop()
        // return inorder(root.right);
        return left && right;
       
        
    }
}
*/
/*4 (but it will fail )
class Solution {
    //TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root,null);
        return flag;
    }
    private void inorder(TreeNode root, TreeNode prev){
        //base
        if(root == null) return;
        //
        inorder(root.left, prev);
        //System.out.println(root.val,prev);
        //st.pop()
        if(prev != null && prev.val >= root.val)
            flag = false;
        //
        prev = root;
        if(flag)
            inorder(root.right, prev);
        //st.pop()
        
    }
}
*/

/*3 optimizing the bellow code
class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        //
        inorder(root.left);
        //st.pop()
        if(prev != null && prev.val >= root.val)
            flag = false;
        //
        prev = root;
        if(flag)
            inorder(root.right);
        //st.pop()
        
    }
}
*/
    
/*2 (checking the condition and making change in flag)
class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        //
        inorder(root.left);
        //st.pop()
        if(prev != null && prev.val >= root.val)
            flag = false;
        //
        prev = root;
        inorder(root.right);
        //st.pop()
        
    }
}

*/

/*1
class Solution {
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return true;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        //
        inorder(root.left);
        //st.pop()
        System.out.println("UP");
        System.out.println(root.val);
        //
        inorder(root.right);
        //st.pop()
        System.out.println("Down");
        System.out.println(root.val);
    }
}
*/