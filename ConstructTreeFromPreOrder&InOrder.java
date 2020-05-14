
// Time Complexity : O(n), where n is the input length
// Space Complexity : O(n*m), where n is the input length and m is the hashmap size
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair{
    int index;
    TreeNode root;
    Pair(int index, TreeNode root){
        this.index=index;
        this.root=root;
    }
}

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
    
    for(int i = 0; i < inorder.length; i++) {
        mapIndex.put(inorder[i], i);
    }

    Pair root = buildTree(preorder, 0,0, preorder.length - 1, mapIndex);
    return root.root;
}

public Pair buildTree(int[] preorder, int index, int start, int end, Map<Integer, Integer> mapIndex) {
    if(start > end) 
        return new Pair(index,null);
    
    TreeNode root = new TreeNode(preorder[index]);
    int pos = mapIndex.get(root.val);
    index++;
    
    Pair left = buildTree(preorder, index , start,pos-1, mapIndex);
    Pair right = buildTree(preorder, left.index, pos+1,end, mapIndex);
    
    root.left = left.root;
    root.right = right.root;
    
    return new Pair(Math.max(left.index,right.index),root);
}
}

