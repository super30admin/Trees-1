// Time Complexity :O(N2)
// Space Complexity :O(N2)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
// 1. root = preorder[0]
// 2. search rootIdx in inorder
// 3. split inorder into left and right
// 4. split preorder into left and right
// 5. root.left == recurse(preorder.left and inoredr.right)
// 6. root.right recurse(preorder.right and inorder.right)
// 7. return root 

// Your code here along with comments explaining your approach
public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
        return null;
    }
    
    int rootIdx = -1;
    int rootVal = preorder[0];
    TreeNode root = new TreeNode(rootVal);
    
    for(int i=0;i<inorder.length;i++){
        if(rootVal == inorder[i]){
            rootIdx =i;
            break;
        }
    }
    
    int[] inorderLeft = Arrays.copyOfRange(inorder,0,rootIdx);
    int[] inorderRight = Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
    int[] preorderLeft = Arrays.copyOfRange(preorder,1,rootIdx+1);
    int[] preorderRight = Arrays.copyOfRange(preorder,rootIdx+1,preorder.length);
    
    root.left = buildTree(preorderLeft,inorderLeft);
    root.right = buildTree(preorderRight,inorderRight);
    
    return root;
    
}
// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes

HashMap<Integer,Integer> map;
    int idx;
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        pre = preorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
            }
        return helper(preorder,0,preorder.length-1);
        }
        private TreeNode helper(int[] preorder, int start, int end){
            if(start>end){
                return null;
            }
            int rootVal = preorder[idx];
            idx++;
            TreeNode root = new TreeNode(rootVal);
            int rootIdx = map.get(rootVal);
            root.left = helper(preorder, start, rootIdx-1);
            root.right = helper(preorder,rootIdx+1,end);
            return root;
        }
    }
