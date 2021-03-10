// Time Complexity :  O(n)+O(n) ,O(n) for inorder traversal and O(n) for traversing the List, where n is number of nodes and size of list
// Space Complexity : O(n) for for list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
-----------------------------------------------------Approach 1 ----------------------------------------------------------------
  class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        
        isValidBST(inOrder, root);
        
        //Traverse through the list and check for violation - here viloation is if array is not sorted
        for(int i=1;i<inOrder.size();i++){
            if(inOrder.get(i)<=inOrder.get(i-1)){
                return false;
            }
        }
        
        return true;
    }
    
    //This function will do  inorder traversal and will add root to list at each point
    public static void isValidBST(List<Integer> result, TreeNode root){
        if(root==null){
            return ;
        }
        
        isValidBST(result,root.left);
        result.add(root.val);
        isValidBST(result,root.right);
    }
}

-----------------------------------------------------Approach 2 ----------------------------------------------------------------
 // Time Complexity : O(n)+O(n) ,O(n) for inorder traversal and O(n) for traversing the List, where n is number of nodes and size of list and also for stack
// Space Complexity : O(2n) for stack and list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
  //This appaorach will make use of stack and follows iterative approach
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        
        isValidBST(inOrder, root);
        
      //check fo violation
        for(int i=1;i<inOrder.size();i++){
            if(inOrder.get(i)<=inOrder.get(i-1)){
                return false;
            }
        }
        
        return true;
    }
    
    public static void isValidBST(List<Integer> result, TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        
        //we will traverse untile curr is not empty or stack is not empty.
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){//go as left as possible
                stack.push(curr);
                curr=curr.left;
            }
            
            curr = stack.pop();//pops the left most element on first traversal.
            result.add(curr.val);//addng result to list at each step
            curr =curr.right;// this will either become null or goes to right node if exist
        }
    }
}

-----------------------------------------------------Approach 3 ----------------------------------------------------------------
 // Time Complexity : O(n) - height of tree 
// Space Complexity : O(n) - recursion stack memory - Recursion stack 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    //TC : O(N) - height of tree SC: Recursion stack 
    //SC : O(N) - recursion stack memory - height of tree
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }
    
    public static boolean validateBST(TreeNode root, Integer min, Integer max){
        if(root==null) return true;
        
        if((min!=null && root.val<=min) || (max!=null && root.val>= max)) return false;//checking for violations
        
        return validateBST(root.left,min,root.val)&& validateBST(root.right,root.val,max);//at each point we are comparing left and right to see if they are true
    }
}
