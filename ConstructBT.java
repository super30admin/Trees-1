// Construct Binary Tree from Preorder and Inorder Traversal

// Brute Force
public class ConstructBT {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int rootval = preorder[0];
        int idx = -1;
        TreeNode root = new TreeNode(rootval);
        
        // Finding the root in the inorder
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootval){
                idx = i;
                break;
            } 
        }
        
        // Creating left and right subtrees based on the root found in inorder
        int[] inLeft = Arrays.copyOfRange(inorder,0,idx); 
        int[] preLeft = Arrays.copyOfRange(preorder,1,inLeft.length+1);
        int[] inRight = Arrays.copyOfRange(inorder,idx+1,inorder.length+1);
        int[] preRight = Arrays.copyOfRange(preorder,inLeft.length+1,preorder.length);
        
        // Building the tree
        root.left = buildTree(preLeft,inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}

// Time Complexity - O(n2)
// Space Complexity - O(n2)

public class ConstructBTOptimized {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length==0) return null;
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start>end) return null;
        
        //logic
        int rootVal = preorder[idx];
        int rootIdx = map.get(rootVal);
        idx++;
        TreeNode root = new TreeNode(rootVal);
        
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder,rootIdx+1,end);
        return root;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)