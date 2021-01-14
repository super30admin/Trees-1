//Problem 42 : Construct Binary Tree from Preorder and Inorder Traversal
// Time Complexity : O(N), N stands for number of nodes
// Space Complexity : O(N), because of HashMap & N recursive call
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Steps : Create a haashmap for storing the inorder elements along with the indexes. Use concept of two pointers which are start & end for building the tree. Always think of how to perform inorder traversal for building the tree. Draw a usecase and then think accordingly .Further get the index of current root which will be called as rIdx. Now for building the left subtree, traverse from start to rIdx-1 and for building the right subtree traverse from rIdx+1 to end which is postorder.length .  
*/

import java.util.*;
class Solution42 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private Map<Integer,Integer> map;
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length==0 || inorder.length==0) return null;
        //preIdx = 0;
        map = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(preorder,0,preorder.length-1);//end will be last element
    }
    
    private TreeNode helper(int[] preorder,int start,int end){
        
        if(start>end) return null;
        
        int rootVal = preorder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(rootVal);
        int rIdx = map.get(rootVal);
        
        root.left  = helper(preorder,start,rIdx-1);
        root.right = helper(preorder,rIdx+1,end);
        
        return root;
    }


    /*Brute Force : //TC: O(n^2)-->O(N) recursive calls * O(N)-> for finding root index in inorder , SC:(N^2), because for N recursive calls we are making a space of O(N) i.e (N^2)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length==0) return null;
        
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int idx = -1;//root index in inorder traversal
        for(int i=0;i<inorder.length;i++){//get root index from the inorder so that left and right elements can be partitioned
            if(inorder[i]==rootVal){
                idx = i;
                break;
            }
        }
        
        //for partitioning inorder array array into left and right
        int[] inLeft  = Arrays.copyOfRange(inorder,0,idx);
        int[] inRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        
        //Now for partitioing the preorder left and right so that scanning of root will be done only for left or right not on the all elements
        
        int[] preLeft  = Arrays.copyOfRange(preorder,1,idx+1);//Here Pre left will be from 1 to inorder idx+1
        int[] preRight = Arrays.copyOfRange(preorder,idx+1,preorder.length);   
        
        
        root.left  = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight,inRight);
        
        return root;
    }*/

}

