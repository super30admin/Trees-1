// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if(preorder.length==0) return null;

//         int rootVal = preorder[0];
//         int rootIdx = -1;

//         for(int i=0;i<inorder.length;i++){
//             if(inorder[i]==rootVal) {
//                 rootIdx=i;
//                 break;
//             }
//         }
//         int[] inLeft= Arrays.copyOfRange(inorder,0,rootIdx); // copyOfRange function requires n+1 values to 
//         //the end to iterate n values
//         int[] inRight = Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
//         int[] preLeft = Arrays.copyOfRange(preorder,1,inLeft.length+1);
//         int[] preRight = Arrays.copyOfRange(preorder,inLeft.length + 1, preorder.length);
//         TreeNode root = new TreeNode(rootVal);
//         root.left = buildTree(preLeft, inLeft);
//         root.right = buildTree(preRight, inRight);

//         return root;
//     }
// }

// time complexity: O(n)
// space complexity : O(n)

class Solution {
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        this.idx=0;
        return helper(preorder,0,preorder.length-1,map);
    }
    private TreeNode helper(int[] preorder, int st, int end, HashMap<Integer, Integer> map){
        //base 
        if(st>end) return null; //--> this works because we need null in cases the values are missing 
        //logic
        int rootVal = preorder[idx];// preoder is a parameter bcs we need the root val
        idx++; // ids is global bcs it stricitly increases 
        TreeNode root= new TreeNode(rootVal);
        int rootIdx= map.get(rootVal);
        //left
        root.left = helper(preorder,st, rootIdx-1,map); // we keep the start the same as in the inital and then move 
        root.right = helper(preorder,rootIdx+1,end,map); 
        return root;
    }
}