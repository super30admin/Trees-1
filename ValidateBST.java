// Time Complexity : O(n) 
// Space Complexity : O(h) h -> height of the stack
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
//Approach: In this approach we keep a previous pointer in the recursion if the pointer exists and if the value is greater than the root 
//then we can return false. We can also prevent executing all the nodes by performing the recursion only if the breach has not happeneded yet
//that is the value is true.
class Solution {
    // boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        // flag=true;
        // helper(root);    
        return helper(root);
    }
    private boolean helper(TreeNode root){
        //base
        if(root == null)return true;

        //logic
        boolean left = helper(root.left);
        if(prev != null && prev.val >= root.val){
            // flag = false;
            return false;
        } 
        prev = root;
        boolean right = true;
        if(left){
            right = helper(root.right);
        }  
        return left && right;
    }
}

//Iterative Solution
class Solution2 {
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root!= null || !st.isEmpty()){
            while(root!= null){
                st.push(root);
                root=root.left;
            }
            root= st.pop();
            if(prev!= null && prev.val>=root.val){
                return false;
            }
            prev= root;
            root=root.right;
        }
        return true;
        
    }
}

//Min max solution
class Solution3 {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null)return true;

        //logic
        if(min!= null && root.val<=min)return false;
        if(max!= null && root.val>=max)return false;

        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}