//Time complexity: O(n)
//Space complexity:O(n)
class Solution {
    int index;
    Map<Integer,Integer> map=new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        index=0;
        return helper(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] preorder,int[] inorder, int start,int end){
        
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(preorder[index]);
        index++;
        int inidx=map.get(root.val);
        root.left=helper(preorder,inorder,start,inidx-1);
        root.right=helper(preorder,inorder,inidx+1,end);
        return root;
    }
}public class binarytree {
    
}