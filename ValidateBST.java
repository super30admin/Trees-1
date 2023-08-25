//Time Complexity: O(n)
//Space Complexity: O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//Methode 1: Void Recursive : used prev, root 
//element get pushed twice here.
class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag;
    }

    //Helper method to check nodes in order
    public void inorder(TreeNode root){
        //base
        if(root==null) return;

        if(!flag) return;

        //left
        inorder(root.left);
        System.out.print("up");
        System.out.print(root.val);

        if(prev!= null && prev.val >= root.val){
            //breach
            flag = false;
            return;
        }
        prev = root;

        //right
        if(flag){
            inorder(root.right);
            System.out.print("down");
            System.out.print(root.val);
        }
    }
}




// Method 2: boolean return based recursion : used prev, root 
class Solution {
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        
        return inorder(root);
     
    }

    //Helper method to check nodes in order
    public boolean inorder(TreeNode root){
        //base
        if(root==null) return true;
       

        boolean left = inorder(root.left);

        if(prev!= null && prev.val >= root.val){
            //breach
            return false;
        }
        prev = root;
        boolean right = false;
        if(left){ // breach condition
            right = inorder(root.right);
        }
        return left && right;
        
    }
}



//Method 3: Iteravtive using Stack : used prev, root 
//element get push only once here
class Solution {
    
    
    public boolean isValidBST(TreeNode root) {
        //inorder
        Stack<TreeNode> st = new Stack<>();

        TreeNode prev=null;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            if(prev!= null && prev.val >= root.val){
                    //breach
                     return false;
            }
            prev = root;
            root = root.right;

        }
        return true;
     
    }
}


//Method 4: Void Recursive : Using low and high limits
class Solution {
    boolean flag;
    
    public boolean isValidBST(TreeNode root) {
        
        this.flag = true;
        helper(root, null , null);
        return flag;

    }

    public void helper(TreeNode root, Integer low, Integer high){

        if(root == null) return ;
        //preorder
        if((low!= null && root.val<=low) || (high!=null && root.val>=high)){
            flag= false;
            return;
        }

        if(flag){//breach condition
            helper(root.left,low,root.val);
        }
        if(flag){
            helper(root.right,root.val,high);
        }
        
    }
}


//Method 5: Boolean Recusive: Using low and high limits

class Solution {
    
    
    public boolean isValidBST(TreeNode root) {
        
       
        return helper(root, null , null);
        

    }

    public boolean helper(TreeNode root, Integer low, Integer high){
        //preorder
        if(root == null) return true;

        if((low!= null && root.val<=low) || (high!=null && root.val>=high)){
            
            return false;
        }

        boolean left =helper(root.left,low,root.val);
        if(left==false) return false; //breach check
        boolean right =helper(root.right,root.val,high);
        return left && right;

        //return helper(root.left,low,root.val) && helper(root.right,root.val,high);
    }

}