import java.util.*;
/*class TreeNode {
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
}*/
public class TreePreIn {
        Map<Integer, Integer> inMap;
        int idx;
        public TreeNode buildTree(int[] preorder, int[] inorder)
        {
            if(preorder.length==0 || inorder.length==0)
            {
                return null;
            }
            inMap= new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            idx=0;
            TreeNode root = recurse(preorder, 0, preorder.length - 1);
            return root;
        }

        public TreeNode recurse(int[] preorder,int start,int end)
        {
            if(start>end)
            {
                return null;
            }
            int rootval= preorder[idx];
            idx++;
            TreeNode root= new TreeNode(rootval);
            int rootIdx=inMap.get(rootval);
            root.left=recurse(preorder,start,rootIdx-1);
            root.right=recurse(preorder, rootIdx+1,end);
            return root;
        }
        public void printInorder(TreeNode node) {
            if (node == null) {
                return;
            }
            printInorder(node.left);
            printInorder(node.right);
            System.out.print(node.val + " ");
        }
        public static void main(String[] args) {
            int[] preorder = {3,9,20,15,7};
            int[] inorder = {9,3,15,20,7};
            TreePreIn tree = new TreePreIn();
            TreeNode root = tree.buildTree(preorder, inorder);
            tree.printInorder(root);
        }
    }

