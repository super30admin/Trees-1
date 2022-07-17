// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
//using iterative approach
// if going in inorder traversal, curr < prev, then it is not a binary tree

// Your code here along with comments explaining your approach

TreeNode prev; // globaly declaring prev node
    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.empty()){
            while(root != null){ // going left
                s.push(root);
                root=root.left;
            }
            root=s.pop(); // poping root element until left is null
            // System.out.print(root.val + " ");
            if(prev != null && prev.val >= root.val){ // checking condtition if the prev >= curr then return false
                return false;
            }
            prev=root; // setting prev to curr for next iteration
            root=root.right;
        }
        
        return true;
    }

// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
//Using min and max concept
// oving left, max = root.val and min = min
// moving right, max = max and min = root.val
// check if root.val lies between min and max
// Your code here along with comments explaining your approach


public boolean isValidBST(TreeNode root) {
    if(root == null) return true;
    
    return helper(root, null,null);
}

private boolean helper(TreeNode root,Integer min,Integer max){
    if(root == null) return true;
    if((min != null && root.val <= min) || (max != null && root.val >= max)){
        return false;
    }
    return helper(root.left,min,root.val) && helper(root.right,root.val,max);
}