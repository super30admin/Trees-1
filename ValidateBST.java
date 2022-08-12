

//By using Recursive solution
class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root, null, null);
        return flag;
    }
    
    
    //return type boolean
    private void helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return;
        if(min != null && root.val <= min) flag = false;
        if(max != null && root.val >= max) flag = false;
        
        //Not to Traversing all the node here
        System.out.println(root.val);
        
        //recursion calls
        
        helper(root.left, min, root.val);
        if(flag)
           helper(root.right, root.val, max);
    }
}



//By using flag , void function
class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root, null, null);
        return flag;
    }
    
    
    //return type boolean
    private void helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return;

        if(min != null && root.val <= min) flag = false;
        if(max != null && root.val >= max) flag = false;
        //Traversing all the node here
        System.out.println(root.val);

        
        //recursion calls
        
        helper(root.left, min, root.val);
        helper(root.right, root.val, max);
    }
}


//boolean function

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {  
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if(root == null) return true;
        
        boolean left = inorder(root.left);
        if( prev != null && prev.val >= root.val){

            return false;
        }
        prev = root;
        boolean right = inorder(root.right);

         return left && right;
    }
    
}


//By using Iterative solution
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        
        while(root != null || !st.isEmpty()){
            //Inoder
            
            while(root!=null){
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





//void function to boolean

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {  
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if(root == null) return true;
        
        boolean left = inorder(root.left);
        if( prev != null && prev.val >= root.val){

            return false;
        }
        prev = root;
        boolean right = inorder(root.right);

         return left && right;
    }
    
}







//optimization

class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {  
        flag=true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root == null)  return;
        //System.out.println(root.val);
        
        inorder(root.left);
        //st.pop() root
        if( prev != null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        
        if(flag)
            inorder(root.right);
        //st.po() root
          
    }
    
}






//  TreeNode is global var

class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {  
        flag=true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root == null)  return;
        //System.out.println(root.val);
        
        inorder(root.left);
        //st.pop() root
        if( prev != null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        inorder(root.right);
        //st.po() root
          
    }
    
}