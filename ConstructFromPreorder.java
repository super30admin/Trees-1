import java.util.HashMap;

public class ConstructFromPreorder {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length ==0) return null;
        this.map = new HashMap<>();
        for(int i=0;i< inorder.length;i++){  //O(n)
            map.put(inorder[i], i);
        }
        
        return helper(preorder,0,inorder.length-1);
      
    }

    public TreeNode helper(int[] preorder,int start,int end){
        if(start>end) return null;

        int rootval = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootval);
        int rootIdx = map.get(rootval); //inorder array index
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1, end);

        return root;
    }
}
