import java.util.HashMap;

public class BuildTreeFromPreOrderInorder {
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int arrlength = inorder.length;
        for (int i = 0; i < arrlength; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, arrlength - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;
        int rootval = preorder[idx];
        TreeNode root = new TreeNode(rootval);
        idx++;
        int rootidx = map.get(rootval);
        root.left = helper(preorder, start, rootidx - 1);
        root.right = helper(preorder, rootidx + 1, end);
        return root;
    }

    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
/*
if(preorder.length==0) return null;

       TreeNode root= new TreeNode(preorder[0]);

       int index=-1;

       for(int i=0;i<inorder.length;i++)
       {
          if(inorder[i]==root.val)
           {
               index=i;
               break;
           }
       }

       int[] preleft=Arrays.copyOfRange(preorder,1,index+1);

       int[] preright=Arrays.copyOfRange(preorder,index+1,preorder.length);

       int[] inleft= Arrays.copyOfRange(inorder,0,index);

       int[] inright=Arrays.copyOfRange(inorder,index+1,inorder.length);

       root.left=buildTree(preleft,inleft);

       root.right=buildTree(preright,inright);

       return root;
 */
//solution-1 Arrays.copyOfRange