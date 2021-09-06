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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0)
            return null;
        TreeNode root=new TreeNode(preorder[0]);
        int index=-1;
        for(int i=0;i<inorder.length;i++){
            if(root.val==inorder[i]){
                index=i;
                break;
            }
        }
        int[] preorderLeft=Arrays.copyOfRange(preorder,1,index+1);
        int[] preorderRight=Arrays.copyOfRange(preorder,index+1,preorder.length);
        int[] inorderLeft=Arrays.copyOfRange(inorder,0,index);
        int[] inorderRight=Arrays.copyOfRange(inorder,index+1,inorder.length);
        root.left=buildTree(preorderLeft,inorderLeft);
        root.right=buildTree(preorderRight,inorderRight);
        return root;
    }
}


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
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
           if(!map.containsKey(inorder[i])){
               map.put(inorder[i],i);
           }
        }
        return helper(preorder,inorder,0,preorder.length-1);
    }
    private TreeNode helper(int[] preorder,int[] inorder,int start,int end){
        //base
        if(start>end){
            return null;
        }
        //logic
        int rootval=preorder[idx];
        idx++;
        int rootidx=map.get(rootval);
        TreeNode root=new TreeNode(rootval);
        root.left=helper(preorder,inorder,start,rootidx-1);
        root.right=helper(preorder,inorder,rootidx+1,end);
        return root;
    }
}