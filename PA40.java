//Iteravtive solution
//Valid BST
//Time : O(n) , n is no of nodes in the tree
//Space : O(n) , where n is the height of the tree. In worst case(Skewed tree) log(n) height will be same as n.
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        
        TreeNode prev=null;
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                
                st.push(root);
                root= root.left;
            }
            
            root = st.pop();
            
            if(prev!=null && prev.val>= root.val){
                return false;
            }
            prev = root;
            root=root.right;
            
        }
        return true;
    }
}

//====================================================
//Valid BST Recursive solution
//Time complexity : O(n) // we are itrating every node of tree
//Space Complexity: O(n) // It the space of stack used in recurssion to store tree nodes.
class Solution {
    TreeNode prev= null;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
      return  helper(root);
    }
    public boolean helper(TreeNode root){
        
        if(root==null){
           
            return true;
        }
        if(!helper(root.left)) return false;
        if(prev!=null && prev.val>= root.val) return false;
        prev= root;
        
        return helper(root.right);
        
    }
}