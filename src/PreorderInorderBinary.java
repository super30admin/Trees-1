import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NP
public class PreorderInorderBinary {
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
    class CopyRecurse {
        public  TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder  == null || preorder.length ==0)return null;
            TreeNode root = new TreeNode(preorder[0]);
            int p  = preorder[0];
            int i=0;
            while(inorder[i] !=p)
            {
                i++;
            }
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, i);
            int[] rightInorder = Arrays.copyOfRange(inorder, i+1, inorder.length);
            int leftPre[] = Arrays.copyOfRange(preorder, 1, i+1);
            int rightPre[] = Arrays.copyOfRange(preorder, i+1, preorder.length);
            root.left = buildTree(leftPre,leftInorder);
            root.right =  buildTree(rightPre,rightInorder);
            return root;
        }
    }

    class WithIndexRecurse {
        int ind =0;
        Map<Integer, Integer> map;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            map = new HashMap<>();
            if(preorder == null ||preorder.length ==0 || inorder.length ==0) return null;
            for(int i=0; i < inorder.length;i++) {
                map.put(inorder[i], i);
            }
            TreeNode root = helper(preorder, inorder, 0, preorder.length-1);

            return root;
        }
        private TreeNode helper(int[] preorder, int[] inorder, int start, int end ){
            if(start> end ){
                return  null ;
            }
            int rootinx = preorder[ind];
            TreeNode root = new TreeNode(rootinx);
            ind++;
            int rootIdx = map.get(root.val);
            TreeNode left = helper(preorder, inorder, start,rootIdx-1);
            TreeNode right = helper(preorder, inorder, rootIdx+1, end);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
