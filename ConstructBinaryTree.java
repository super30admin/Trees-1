import java.util.HashMap;

public class ConstructBinaryTree {

    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    /*
    * Bifurcate each array into 3 parts primarily as we  know root from preorder. Start with bigger problem and
    * divide it into small parts and recursively call it.
    *
    *
    * TC - O(n)
    * SC - O(n) - hashmap present
    * */

    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || preorder ==null || inorder.length ==0 ) return null;
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recurse(preorder,inorder, 0,inorder.length-1);

    }
    private TreeNode recurse(int[] preorder, int[] inorder, int start,int end){
        if(start>end) return null;
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left= recurse(preorder,inorder, start, rootIdx-1);
        root.right = recurse(preorder,inorder, rootIdx+1,end );
        return root;
    }


}
