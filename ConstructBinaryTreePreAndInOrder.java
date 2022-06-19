import java.util.HashMap;

//TimeComplexity=O(n)
//Space Complexity=O(n);
public class ConstructBinaryTreePreAndInOrder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    HashMap<Integer,Integer> map;
    int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0){
            return null;
        }
        map=new HashMap();
        for(int i=0;i<inorder.length;i++){

            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }

    public TreeNode helper(int[] preorder,int start,int end){

        if(start>end) return null;
        int rootVal=preorder[idx];
        // System.out.println(rootVal);
        idx++;
        TreeNode root=new TreeNode(rootVal);
        int rootIndex=map.get(rootVal);
        root.left=helper(preorder,start,rootIndex-1);
        root.right=helper(preorder,rootIndex+1,end);

        return root;
    }
}
