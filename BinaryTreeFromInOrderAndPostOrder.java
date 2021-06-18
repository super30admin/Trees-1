import java.util.HashMap;
import java.util.Map;
// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
InOrder Traversal: Left Root Right
PreOrder Traversal: Root Left Right
1. To get the root we mantain a preIndex and we can iterate over preOrder array using this index
2. we find the find this root in the inorder array and the left side would give us the left subtree to this node and right side would give right subtree to this node.
3. we can recursively assign left and right nodes to this node and each root in the preOrder array.


*/

public class BinaryTreeFromInOrderAndPostOrder {
    int preIndex=0;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return construct(preorder,inorder,0,preorder.length-1);
    }
    public TreeNode construct(int[] preorder, int[] inorder,int start,int end)
    {
        if(start>end)
            return null;
        //System.out.println(preIndex);
        TreeNode root=new TreeNode(preorder[preIndex++]);
        int inIndex=map.get(root.val);
        /*for(int i=start;i<=end;i++)
        {
            if(inorder[i]==root.val)
            {
                inIndex=i;
                break;
            }
        }*/
        root.left=construct(preorder,inorder,start,inIndex-1);
        root.right=construct(preorder,inorder,inIndex+1,end);
        return root;
    }
}
