//Approach-1: Using the current pointer and the previous pointer and a void function
class Solution {
    TreeNode prev;
    boolean flag;
    
    public boolean isValidBST(TreeNode root) {
        flag = true;
        checkBST(root);
        return flag;
    }
    
    private void checkBST(TreeNode curr){
        if(curr == null) return;
        
        checkBST(curr.left);
        
        if(prev != null && curr.val <= prev.val){
            flag = false;
        } 
        
        prev = curr;
        
        checkBST(curr.right);
    }
}


//Approach-2: Using the current pointer and the previous pointer and a boolean function
class Solution {
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        return checkBST(root);
    }
    
    private boolean checkBST(TreeNode curr){
        if(curr == null) return true; 
        
        boolean left = checkBST(curr.left);
        
        if(prev != null && curr.val <= prev.val){
            return false;
        } 
        
        prev = curr;
        
        boolean right = checkBST(curr.right);
        
        return left && right;
    }
}


//Approach-3: Using the current pointer and the previous pointer - Iterative Way
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.isEmpty()){
            //Move left
            while(root != null){
                st.push(root); //Push element into the stack
                root = root.left;
            }
            root = st.pop();
            
            if(prev != null && root.val <= prev.val) return false;
            
            prev = root;
            root = root.right;
        }
        
        return true;
    }

}


//Approach-4: Using the limit approach - boolean function
class Solution {
    
    //Range of node.val ; -2^31 <= Node.val <= 2^31 - 1
    //Hence we are taking Integer class and we use null
    public boolean isValidBST(TreeNode root) {
        return checker(root, null, null);
    }
    
    public boolean checker(TreeNode node, Integer min, Integer max){
        if(node == null) return true;
        if((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        
        return checker(node.left, min, node.val) && checker(node.right, node.val, max);
    }

}

//Approach-5: Using the limit approach - void function
class Solution {
    boolean flag;
    
    //Range of node.val ; -2^31 <= Node.val <= 2^31 - 1
    //Hence we are taking Integer class and we use null
    public boolean isValidBST(TreeNode root) {
        flag = true;
        checker(root, null, null);
        return flag;
    }
    
    public void checker(TreeNode node, Integer min, Integer max){
        if(node == null) return;
        if((min != null && node.val <= min) || (max != null && node.val >= max)) flag=false;
        
        checker(node.left, min, node.val);
        checker(node.right, node.val, max);
        
        return;
    }

}