
// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
import java.util.HashMap;
public class ConstructBinaryTree {
    int index=0;
    HashMap<Integer,Integer>hm=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helpermethod(preorder,0,preorder.length-1);
    }
    private TreeNode helpermethod(int []preorder,int start,int end){
        if(start>end){return null;}
        TreeNode root=new TreeNode(preorder[index++]);
        int i=hm.get(root.val);
        root.left=helpermethod(preorder,start,i-1);
        root.right=helpermethod(preorder,i+1,end);
        return root;
    }
}
