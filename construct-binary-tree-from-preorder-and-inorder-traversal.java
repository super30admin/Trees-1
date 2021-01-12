// Time Complexity : O(n) n:number of nodes
// Space Complexity : O(h) h:height of tree
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

//traverse preorder arr, find the node in inorder array, left of the node should be on the left side in inorder arr
// and right of the node should be on right side of inorder array.

// Your code here along with comments explaining your approach

int p = 0;
public TreeNode buildTree(int[] preorder, int[] inorder) {
    int len = preorder.length;
    if(len == 0) return null;
    Map<Integer,Integer> in = new HashMap<>();
    for(int i = 0; i< len;i++) in.put(inorder[i],i);
    return construct(inorder,preorder,in,0,len-1);
}
private TreeNode construct(int[] inorder, int[] preorder, Map<Integer,Integer> in,int l, int r){
    if(l>r)return null;       
    TreeNode root = new TreeNode(preorder[p]);
    int pos = in.get(root.val);
    //System.out.println("pos:" + pos + " l:" + l + " r:" + r + " p:" + p + " preorder[p]:" + preorder[p]);
        p++;
    root.left = construct(inorder,preorder,in,l,pos-1);
    root.right = construct(inorder,preorder,in,pos+1,r);
    return root;
}