import java.util.*;

class TreeNode {
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
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        if(preorder.length==0 || inorder.length==0) return null;
        int rootVal=preorder[0];
        int rootIndex=-1;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootVal)
            {
                rootIndex=i;
                break;
            }
        }
        int[] inLeft=Arrays.copyOfRange(inorder,0,rootIndex);
        int[] inRight=Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
        int[] preLeft=Arrays.copyOfRange(preorder,1,inLeft.length+1);
        int[] preRight=Arrays.copyOfRange(preorder,inLeft.length+1,preorder.length);
        TreeNode root=new TreeNode(rootVal);
        root.left=buildTree(preLeft,inLeft);
        root.right=buildTree(preRight,inRight);
        return root;
    }
}

class BuildTree2
{
    HashMap<Integer,Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder,int[] inorder)
    {
        if(preorder.length==0 || inorder.length==0) return null;
        this.map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);


    }
    private TreeNode helper(int[] preorder,int start,int end)
    {
        if(start>end)  return null;
        int rootVal=preorder[index];
        index++;
        int rootIndex=map.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        root.left=helper(preorder,start,rootIndex-1);
        root.right=helper(preorder,rootIndex+1,end);
        return root;
    }
}