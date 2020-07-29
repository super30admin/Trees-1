import java.util.Arrays;
import java.util.HashMap;

public class ConstructBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//Time Complexity : O(n^2)
//Space Complexity: O(n^2)
/*Approach
-In preorder the first node will always be the root,taking the root from preorder
searching it in inorder
-the left of the root in inorder will form the left subtree and right will form the right subtree
-again taking parts from inorder and preorder and repeating the same process of forming root and left,right
subtree
 */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if(inorder.length == 0 || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = -1;
        for(int i = 0;i < inorder.length; i++){
            if(inorder[i] == root.val){
                rootIndex = i;
            }
        }
        int[] preLeft= Arrays.copyOfRange(preorder,1,rootIndex+1);
        int[] preRight=Arrays.copyOfRange(preorder,rootIndex+1,preorder.length);
        int[] inLeft=Arrays.copyOfRange(inorder,0,rootIndex);
        int[] inRight=Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
        
        root.left = buildTree1(preLeft,inLeft);
        root.right = buildTree1(preRight,inRight);
        return root;
    }
//2 
//Time Complexity : O(n)
//Space Complexity: O(n)
/*Approach
same as above but doing recursively and also using hashmap to store index of nodes in inorder
to access in O(1) while searching for root.
-taking start and end index and it will be start to rootIndex-1 for left subtree
and rootIndex+1 to end for right subtree
 */


    HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex = 0 ;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder, inorder,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if(root == null) return null;
        if(start == end) return root;
        
        int i = map.get(root.val);
        root.left = build(preorder,inorder,start,i-1);
        root.right = build(preorder,inorder,i+1,end);
        return root;
    }
    public static void main(String args[]){
        ConstructBT obj = new ConstructBT();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        System.out.println(obj.buildTree1(preorder, inorder).val);
        System.out.println(obj.buildTree2(preorder, inorder).val);
    }


}