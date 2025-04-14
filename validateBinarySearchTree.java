import java.util.HashMap;

public class validateBinarySearchTree 
{
    public class TreeNode 
    {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) 
        {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
    int j= 0;
    public TreeNode insert(int[] postorder,HashMap<Integer,Integer> map,int l,int r)
    {
        TreeNode root = new TreeNode(postorder[j]);
        int x = map.get(postorder[j]);
        if(r>x  && j-1>=0)
        {
            j--;
            root.right = insert(postorder,map,x+1,r);
        }
        if(x>l && j-1>=0)
        {
            j--;
            root.left = insert(postorder,map,l,x-1);
        }
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        this.j= postorder.length-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return insert(postorder,map,0,inorder.length-1);
    }
}