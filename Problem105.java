package problems.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// Time Complexity : O(n)
// Space Complexity : O(n)
public class Problem105 {
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map= new HashMap<>();
        this.index=0;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length,map);
    }
    private TreeNode helper(int[] preorder, int start, int end, Map<Integer,Integer> map)
    {
        if (start>=end)
        {
            return null;
        }
        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);
        int indexInInorder = map.get(rootVal);
        root.left = helper(preorder, start, indexInInorder,map);
        root.right = helper(preorder, indexInInorder+1, end,map);
        return root;
    }

    public TreeNode buildTreeRecursive(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        int pLength=preorder.length;
        int iLength=inorder.length;
        int rootVal=preorder[0];
        int rootIdx=-1;

        TreeNode root=new TreeNode(rootVal);
        for(int i=0;i<iLength;i++){
            if(rootVal==inorder[i]){
                rootIdx=i;
                break;
            }
        }
        int[] inLeft= Arrays.copyOfRange(inorder,0,rootIdx);
        int[] inRight=Arrays.copyOfRange(inorder,rootIdx+1,iLength);
        int[] preLeft=Arrays.copyOfRange(preorder,1,inLeft.length+1);
        int[] preRight=Arrays.copyOfRange(preorder,inLeft.length+1,pLength);

        root.left=buildTree(preLeft,inLeft);
        root.right=buildTree(preRight,inRight);
        return root;
    }
}
