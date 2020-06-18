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
    int index = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         map = new HashMap<Integer,Integer>();
        int sPtr = 0; int endPtr = 0;
        for(int i = 0 ; i< inorder.length ;i++){
            map.put(inorder[i],i);
        }
       // int inorderIdx = set.get(preorder[0]); //inorder root index from preorder
       //  root.left = helper(preorder,inorder,sPtr,inorderIdx-1);
       // root.right = helper(preorder,inorder,inorderIdx+1,endPtr);
        
        return helper(preorder,inorder,0,inorder.length-1);
    }
       
    
    private TreeNode helper(int[] preorder, int[] inorder,int startPtr ,int endPtr){
        //base 
        //exit when start and endptr cross or index reached out of bounds
        if(startPtr > endPtr || index == preorder.length) return null;
        
        TreeNode root = new TreeNode(preorder[index]); //initially globally index of preorder = 0
        
        int inorderIdx = map.get(root.val);  //retrieved in O(1) is the root
        index++;
        
        root.left = helper(preorder,inorder,startPtr,inorderIdx - 1);
        
        root.right = helper(preorder,inorder,inorderIdx+1,endPtr);
        
        return root;
        
    }
}
/*
TimeComplexity O(n) because we are visiting every node once
SpaceComplexity O(n) because used hashmap for computation 
*/

/*Output
[3,9,20,15,7]
[9,3,15,20,7]
Output
[3,9,20,null,null,15,7]
*/