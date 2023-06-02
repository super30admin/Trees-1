class Solution {
    public boolean isValidBST(TreeNode root) {
        return DFS(root,null,null);
    }
    
    private boolean DFS(TreeNode root,Integer min,Integer max){
        if(root == null) return true;
        if(min != null && (root.val <= min)) return false;
        if(max !=null && (root.val >= max)) return false;
        return (DFS(root.left,min,root.val) && DFS(root.right,root.val,max));
        
    }
    
}

class Solution {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length==0) return null;
        map = new HashMap<>();
        int i=0;
        while(i<inorder.length){
            map.put(inorder[i],i);
            i++;
        }
        return DFS(preorder,0,inorder.length-1);        
    }
    
    private TreeNode DFS (int[] preorder, int start, int end){
        //base
        if(start > end) return null;
        
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        
        root.left = DFS(preorder,start,rootIdx - 1);
        root.right = DFS(preorder,rootIdx+1,end);
        return root;
        
        
    }
}
