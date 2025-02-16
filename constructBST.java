import java.util.HashMap;

public class constructBST {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++)
            map.put(inorder[i],i);
        int preindex[] = {0};
        return build(preorder,map,preindex,0,inorder.length-1);
    }
    public TreeNode build(int preorder[], HashMap<Integer,Integer> map, int preindex[], int left, int right){
        if(left > right)
            return null;
        int rootVal = preorder[preindex[0]];
        preindex[0]++;
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.left = build(preorder,map,preindex,left,index-1);
        root.right = build(preorder,map,preindex,index+1,right);
        return root;
    }
}
