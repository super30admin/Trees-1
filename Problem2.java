//Construct BST from preorder and inorder arrays
//Brute Force
//Space Complexity : O(n2) : Creating 4arrays at every node
//Time Complexity : O(n2) : O(n) for traversing * O(n) for constructing tree
public class Problem2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder ==null || preorder.length==0){
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx=-1;
        
        for(int i=0; i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootIdx=i;
                break;
            }
        }
    
        int[] inorderLeft=Arrays.copyOfRange(inorder,0,rootIdx);
        int[] inorderRight=Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        int[] preorderLeft = Arrays.copyOfRange(preorder,1,rootIdx+1);
        int[] preorderRight =Arrays.copyOfRange(preorder,rootIdx+1,preorder.length);
        
        root.left = buildTree(preorderLeft,inorderLeft);
        root.right = buildTree(preorderRight,inorderRight);
        
        return root;
}

//Construct BST from preorder and inorder arrays
//Optimization
//Time complexity : o(n)
//Space complexity : o(n)
//Using hashmap for optimization, for constant search operation in inorder array. 
//Passing index instead of creating new array when visit any node for space optimization
public Map<Integer,Integer> map = new HashMap<>();
int idx;
public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder==null || inorder ==null || preorder.length==0){
        return null;
    }
    for(int i=0; i<inorder.length;i++){
        map.put(inorder[i],i);
    }

    return helper(preorder,0,preorder.length-1);
}

private TreeNode helper(int[] preorder, int start, int end){
    if(start>end){
        return null;
    }
    int rootVal= preorder[idx];
    //incrementing to move towards next root
    idx++;
    TreeNode root = new TreeNode(rootVal);
    int rootIdx=map.get(rootVal);
    root.left = helper(preorder,start,rootIdx-1);
    root.right = helper(preorder,rootIdx+1,end);
    return root;
}