//TimeComplexity O(n)
//Spacecomplexity O(n) hashmao

class Solution {
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       if(preorder.length == 0)return null;
        map = new HashMap<>();  
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);       
    }
    
    private TreeNode helper(int[] preorder, int start, int end){
        if(start > end) return null;
        
        int rootVal = preorder[index];
        index++;
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        
        root.left = helper(preorder,start, rootIndex-1);
        root.right = helper(preorder,rootIndex+1,end);
        return root;       
    }
}
