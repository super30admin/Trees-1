
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// Recursive approach, validating the all left elements are less than the root
// and all right elements are greater than root.

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validBST(root, null, null);
        
    }
    
    private boolean validBST(TreeNode node, Integer min, Integer max){
        if(node==null)
            return true;
        
        if((min!=null && min >=node.val) || (max!=null && max<=node.val))
            return false;
        
        return validBST(node.left, min, node.val) &&
            validBST(node.right, node.val, max);
    }
    
    
}


// Iterative
class Solution {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> minList = new LinkedList<>();
    LinkedList<Integer> maxList = new LinkedList<>();
    
    private void updateValue(TreeNode root, Integer min, Integer max){
        stack.add(root);
        minList.add(min);
        maxList.add(max);
    }
    
    public boolean isValidBST(TreeNode root) {
        Integer min=null;
        Integer max=null;
        updateValue(root, min, max);
        
        while(!stack.isEmpty()){
            root = stack.poll();
            min = minList.poll();
            max = maxList.poll();
            
            if(root == null)
                continue;
            
            if(min!=null && min >= root.val)
                return false;
            if(max!=null && max<= root.val)
                return false;
            
            updateValue(root.left, min, root.val);
            updateValue(root.right, root.val, max);
        }
        return true;
    }