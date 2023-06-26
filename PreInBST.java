// Time Complexity o(h) Space complexity o(h)

class Solution {
    
    int idx;
    HashMap<Integer,Integer> m;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        m = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
              m.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode helper(int[] preorder,int[] inorder,int start,int end){
         if(start>end) return null;
         int rootval=preorder[idx];
         idx++;
         int rootidx=m.get(rootval);
         TreeNode root = new TreeNode(rootval);

         root.left=helper(preorder,inorder,start,rootidx-1);
         root.right=helper(preorder,inorder,rootidx+1,end);

         return root;
    }

}