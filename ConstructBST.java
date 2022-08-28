import java.util.HashMap;


//Approach 1 - Brute Force
public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder.length == 0)
        return null;
    int rootVal = preorder[0];
    TreeNode root = new TreeNode(rootVal);
    int rootIdx = -1;
    
    for(int i = 0; i < inorder.length;i++)
    {
        if(inorder[i] == rootVal)
        {
            rootIdx = i;
        }
    }
    
    int iLeft[] = Arrays.copyOfRange(inorder,0,rootIdx);
    int iRight[] = Arrays.copyOfRange(inorder,rootIdx + 1, inorder.length);
    int pLeft[] = Arrays.copyOfRange(preorder,1,iLeft.length + 1);
    int pRight[] = Arrays.copyOfRange(preorder,rootIdx + 1,preorder.length);
    
    root.left = buildTree(pLeft,iLeft);
    root.right = buildTree(pRight,iRight);
    return root;
}

//Approach 2 - Optimal solution

public class ConstructBST {
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

    HashMap<Integer,Integer> hash = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        for(int i = 0; i<preorder.length;i++)
        {
            hash.put(inorder[i],i);
        }
        
        return helper(preorder,0,inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder,int start,int end)
    {
        //base
        //if start is greater than end that means start and end have crossed each other
        if(start > end)
        {
            return null;
        }
        
        //logic
        int rootVal = preorder[index];
        index++;
        int rootIndx = hash.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder,start,rootIndx - 1);
        root.right = helper(preorder,rootIndx + 1,end);
        return root;
    }
}
