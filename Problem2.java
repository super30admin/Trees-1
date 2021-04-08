//Construct tree from preeorder & inorder
// Time Complexity : O(n) n - number of nodes
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/*
We use recursive approach but we maintain a hashmap to save the index of preorder 
We first build a map of inorder array with nodes and its respective indexes. 
Then we use a recursive helper method, that iterates from 0-n. 
We get the index of the node from map and then form an tree by using start and end 
Start till index would be left subtree and index to end will be right subtree and we go
on increasing the index
*/

import java.util.*;
public class Problem2 {
    public static void main(String[] args){
        int[] preoder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        buildTree(preoder, inorder);


    }
    public static HashMap<Integer, Integer> map;
    public static int index;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //hashmap approach 
        if(preorder == null || preorder.length ==0)
            return null;
        map = new HashMap<>();
        index = 0;
        //forming the map
        for(int i = 0;i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0, inorder.length-1);
            
        
    }
    public static TreeNode helper(int[] preorder, int start, int end){
        if(start > end){
            return null;
        }
        //root will be the node at index in preorder array
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int inorderIndex = map.get(root.val);
        root.left = helper(preorder,start, inorderIndex-1);
        root.right = helper(preorder, inorderIndex+1, end);
        return root;
        
    }
    
}
