//optimized using Hashmap;
//T.C : O(n)
//S.C: O (n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //happy case
        if(preorder==null || inorder==null || preorder.length==0)return null;
        map=new HashMap<>();
        int rootVal=preorder[0];
        TreeNode root=new TreeNode(rootVal);
        int rootIndex=-1;
        //find index of root in inorder
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);             
        }
        return helper(preorder,0,preorder.length-1);
        
        
    }
    private TreeNode helper(int[] preorder,int start,int end){
        //base case
        if(start>end){
            return null;
        }
        //logic
        int rootVal=preorder[index];
        index++;
        TreeNode root=new TreeNode(rootVal);
        int rootIndex=map.get(rootVal);
        root.left=helper(preorder,start,rootIndex-1);
        root.right=helper(preorder,rootIndex+1,end);
        return root;
    }  
    }
