import java.util.*;
//Definition for a binary tree node.
public class TreeFromInandPre {
        int preorderIndex;
        Map<Integer, Integer> inorderIndexMap;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preorderIndex = 0;
            // build a hashmap to store value -> its index relations
            inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }

            return arrayToTree(preorder, 0, preorder.length - 1);
        }

        private TreeNode arrayToTree(int[] preorder, int left, int right) {
            if (left > right) return null;


            int rootValue = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootValue);


            root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
            root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
            return root;
        }
        public static void main(String[] args){
            int [] preorder = {3,9,20,15,7};
            int [] inorder = {9,3,15,20,7};
            TreeFromInandPre t = new TreeFromInandPre();
            System.out.print(t.buildTree(preorder,inorder));
        }
}
