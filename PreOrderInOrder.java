//Time Complexity: O(n)
//Space Complexity: O(n)
import java.util.HashMap;
import java.util.Map;

public class PreOrderInOrder {
    int preorderIndex;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex=0;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return binaryTree(preorder, 0, preorder.length-1);

    }

    public TreeNode binaryTree(int[] preorder, int left, int right){
        if(left>right){
            return null;
        }
        int rootValue = preorder[preorderIndex];
        preorderIndex++;
        TreeNode treeNode = new TreeNode(rootValue);

        treeNode.left = binaryTree(preorder, left, map.get(rootValue)-1);
        treeNode.right = binaryTree(preorder, map.get(rootValue)+1, right);

        return treeNode;
    }
}
