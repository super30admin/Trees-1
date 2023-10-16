// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Use a hashmap, maintain the keys as the values of inorder array and values as its indices
 * Use a recursive helper function, that everytime take the end as rootIndex -1 while calculating root.left
 * and start as  rootIndex +1 while calculating root.right
 */
import java.util.*;
class Solution {
    int idx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        for(int i=0;i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int start, int end){
        if(start> end) //Base
            return null;
        int rootValue = preorder[idx]; //Logic
        idx++;
        int rootIdx = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1,end);
        return root;
    }
}