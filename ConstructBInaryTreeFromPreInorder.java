// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Create a map of inoder indexes, recursively build tree from preorder,
//by using indexes
public class ConstructBInaryTreeFromPreInorder {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0) return null;

        map= new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder, 0, preorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start, int end){
        if(start>end) return null;

        int rootVal= preorder[idx];
        idx++;
        int rootIdx= map.get(rootVal);

        TreeNode root= new TreeNode(rootVal);

        root.left=helper(preorder, start, rootIdx-1);
        root.right=helper(preorder,rootIdx+1,end);

        return root;
    }
}
//https://www.youtube.com/watch?v=JO03i8ggKhw
