
So in this it is same as that of Inorder, preorder just the difference here is in this the last element of postorder is a root and previously the first elemnt of preorder was the root

T.C = O(n^2)
S.C = O(n^2)

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || postorder.length == 0 || inorder.length==0 || inorder == null){
            return null;
        }
        int index = 0;
        for(int i=0;i<inorder.length;i++){
            if(postorder[postorder.length-1]==inorder[i]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int[] inorderleft = Arrays.copyOfRange(inorder,0, index);
        int[] inorderright = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] postorderleft = Arrays.copyOfRange(postorder,0, index);
        int[] postorderright = Arrays.copyOfRange(postorder,index,postorder.length-1);

        root.left = buildTree(inorderleft,postorderleft);
        root.right = buildTree(inorderright,postorderright);
        return root;
    }
}

//Optimal solution using Map


//In this remember we need to build right tree first and then only left tree else it will not work as we are decrementing rootIndex

class Solution {
    HashMap<Integer,Integer> map;
    int rootIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || postorder.length == 0 || inorder.length==0 || inorder == null){
            return null;
        }
        map = new HashMap<>();
        rootIndex = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            if(!map.containsKey(inorder[i])){
                map.put(inorder[i],i);
            }
        }

        return dfs(postorder,0,inorder.length-1);
    }

    private TreeNode dfs(int[] postorder, int start, int end){
        if(start > end){
            return null;
        }
        int value = postorder[rootIndex];
         rootIndex--;
        int index = map.get(value);
        TreeNode root = new TreeNode(value);
        //Right first 
          root.right = dfs(postorder,index+1,end);
        //Left 
          root.left = dfs(postorder,start,index-1);
        return root;
    }
}