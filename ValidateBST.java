
// Time Complexity : O(N) - N is size of the arrayList
// Space Complexity : O(N) - As we use a additional data structure(ArrayList)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english 

//Used an arraylist to store all the elements of the tree by performing Inorder traversal
//Then use a for loop to loop through the array and check for the condition where left element is greater than right
//If found return false as it violates BST property else finally return true
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public ArrayList inOrder(TreeNode root,ArrayList arr1){
        if(root == null){
            return arr1;
        }
        arr1 = inOrder(root.left,arr1);
        arr1.add(root.val);
        arr1 = inOrder(root.right,arr1);
        return arr1;
    }
    public boolean isValidBST(TreeNode root) {
     ArrayList<Integer> arr1 = new ArrayList<>();
      if(root == null){
          return true;
      }
        if(root.left == null && root.right == null){
            return true;
        }
        arr1 = inOrder(root,arr1);
        for(int i = 0;i < arr1.size() - 1;i++){
            if(arr1.get(i) >= arr1.get(i+1)){
                return false;
            }
        }
       return true;
    }
}
// Your code here along with comments explaining your approach
