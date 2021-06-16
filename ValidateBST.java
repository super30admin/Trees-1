// All the approaches ran well on leetcode 

/*SC - O(H) TC -O(N) Approach - iterative way check previous nodes' value every time we visit new node  
 * */

class Solution {
    public boolean isValidBST(TreeNode root) {
        
        TreeNode prev = null; 
        Stack<TreeNode> stack = new Stack<>();
       
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right; 
        }
        return true;
        
    }
}

// Approach 2  - recursive way 

/*SC - O(H) TC -O(N) Approach - recursive way check previous nodes' value every time we visit new node */

class Solution {
    boolean result; 
    TreeNode prev= null;
    public boolean isValidBST(TreeNode root) {
        result = true;
        helper(root);
        return result;
    }
    
    public void helper(TreeNode root){
        if (root == null) return; 
        
        helper(root.left);
        if (prev != null && prev.val >=root.val) {result = false; return ;}
        prev = root;
        helper(root.right);
        
    }
}


// Approach 3 - using range  
class Solution {
    boolean result  = true;
    public boolean isValidBST(TreeNode root) {
        // rot, min and max is null
        helper(root, null, null);
        return result;
    }
    
    // using range
    public void helper(TreeNode root, Integer min, Integer max){
        
        if (root == null) return;
        if (max != null && root.val >= max ){result = false; return ; }
        
         if (min != null && root.val <= min ){result  =  false; return ; }
        
        // left max changes to its parent , min same 
        helper(root.left,min, root.val );
        // right min changes,  max remains same
        helper(root.right, root.val, max);
    }
    
}
