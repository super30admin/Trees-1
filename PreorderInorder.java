import  java.util.*;

public class PreorderInorder {
      public class TreeNode {
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

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        /*
        Approach 1: Brute Force
        TC: O(n^2)
        SC: O(n^2)

        */
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0){
            return null;
        }

        int rootVal=preorder[0];
        int rootIdx=-1;
        TreeNode root=new TreeNode(rootVal);

        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootIdx=i;
                break;
            }
        }

        int inLeft[]=Arrays.copyOfRange(inorder,0,rootIdx);
        int inRight[]=Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        int preLeft[]=Arrays.copyOfRange(preorder,1,rootIdx+1);
        int preRight[]=Arrays.copyOfRange(preorder,rootIdx+1,preorder.length);

        root.left=buildTree(preLeft,inLeft);
        root.right=buildTree(preRight,inRight);
        return root;
    }

    /*
    Approah 2: Optimized solution
    */
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    /*

    TC: O(n)
    SC: O(n)

    */
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0){
            return null;
        }
        map=new HashMap<>();
        idx=0;

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,inorder.length-1);
    }

    private TreeNode helper(int preorder[],int start,int end){
        //base
        if(start>end){
            return null;
        }

        //logic
        int rootVal=preorder[idx];
        TreeNode root=new TreeNode(rootVal);
        idx++;
        int rootIdx=map.get(rootVal);

        root.left=helper(preorder,start,rootIdx-1);
        root.right=helper(preorder,rootIdx+1,end);
        return root;
    }
}
