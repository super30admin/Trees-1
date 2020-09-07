
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// Recursive approach, validating the all left elements are less than the root
// and all right elements are greater than root.

class Solution {
    
    // Iterative
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0 )
            return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
 
        int index=0;
        for(int i=1; i<preorder.length; i++){
            TreeNode curr = new TreeNode(preorder[i]);
            TreeNode prev = null;
            while(!stack.isEmpty() && stack.peek().val == inorder[index]){
                prev = stack.pop();
                index++;
            }
            
            if(prev!=null){
                prev.right = curr;
            }else{
                stack.peek().left = curr;
            }
            stack.push(curr);
        }
        return root;  
    }
    
    

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    
    // Three line explanation of solution in plain english
    // Storage the index in map for inorder
    // Used two indexes: start and end for inorder and 1 index for preorder
    // Left side is built from start to inOrderIndex -1
    // Right side is build from inOrderIndex -1 to end

    // Recursion
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTreeRecursion(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder,inorder, 0, inorder.length-1, 0) ;
    }
    
    // index refers to the current index of preorder[]
    // start refers to the start index of inorder[]
    // end refers to the end index of inorder[]
     private TreeNode helper(int[] preorder, int[] inorder, int start , int end, int index){   
        if (start > end)
            return null;
        
        TreeNode root = new TreeNode(preorder[index]);
        
        int inOrderIndex = map.get(preorder[index]);
        int leftLength = inOrderIndex - start + 1;

        root.left = helper(preorder, inorder, start, inOrderIndex-1, index+1);
        root.right = helper(preorder, inorder, inOrderIndex+1, end, index 
+ leftLength);
        return root;
    }
}