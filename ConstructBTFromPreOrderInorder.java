import java.util.HashMap;


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach


public class ConstructBTFromPreOrderInorder {
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

        HashMap<Integer,Integer> hmap = new HashMap<>();
        int preorderindex=0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length ==0){
                return null;
            }

            int start =0, end = inorder.length-1;
            for(int i=0;i<inorder.length;i++){
                hmap.put(inorder[i], i);
            }

            return buildTree(start, inorder.length-1 ,preorder);
        }

        public TreeNode buildTree(int start, int end, int[] preorder){
            System.out.println(" start "+start +" end "+end );
            if(start > end){
                return null;
            }

            int rootval =  preorder[preorderindex++];
            System.out.println(" rootval "+ rootval );
            TreeNode root = new TreeNode(rootval);
            int inorderindex = hmap.get(rootval);

            root.left = buildTree(start, inorderindex-1,preorder);
            root.right = buildTree(inorderindex+1,end, preorder);

            return root;
        }
    }
}
