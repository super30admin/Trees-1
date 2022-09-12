// Recursive

//TimeComplexity O(n)
//Spacecomplexity O(h) height of the tree / Space utilized by stack which stores at max nodes in the hieghest path i.e height of the tree(h)

class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }

    
    private void inorder(TreeNode root){
        if(root == null)return;
        
        //
        if(flag){
            inorder(root.left);
        }
        
        if(prev != null && prev.val >= root.val){
            flag = false;
            return;
        }
        prev = root;
        
        if(flag){
            inorder(root.right);
        }
}
}

//Iterative

//TimeComplexity O(n)
//SpaceComplexity O(h) height of the tree / Space utilized by stack which stores at max nodes in the hieghest path i.e height of the tree(h)

class Solution {
  
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root != null || !st.isEmpty()){
            while(root != null){
              st.push(root);
              root =  root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
}
}

//Limit 

//Time Complexity. O(n)
//Space complexity O(h)

class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
       helper(root,null,null);
        return flag;
}
    private void helper(TreeNode root,Integer min, Integer max){
        //base
        if(root == null)return;
        if(min != null && root.val <= min)flag = false;
        if(max != null && root.val >= max)flag = false;
        
        
        if(flag){                           //traversal stops one flag is false and unnecessary recursive calls are stopped.
        helper(root.left, min, root.val);
        helper(root.right,root.val,max);
        }
    }
}
