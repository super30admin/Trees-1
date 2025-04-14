import java.util.HashMap;

public class PreOrderInorder 
{
    public class TreeNode 
    {
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
    int j =0;
    public TreeNode insert(int l,int r,int[] preorder,HashMap<Integer,Integer> map)
    {
        TreeNode root = new TreeNode(preorder[j]);
        int x = map.get(preorder[j]);
        //int rem = x-l;
        if(l<=x-1)
        {
            j++;
            root.left = insert(l,x-1,preorder,map);
        }
        if(r>=x+1)
        {
            j++;
            root.right = insert(x+1,r,preorder,map);
        }
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root = null;
        return insert(0,preorder.length-1,preorder,map);
    }
}