import java.util.HashMap;


public class BinaryTree_InOrderPre_RecursionOpt {

        HashMap<Integer, Integer> mapInNumIdx;

        // preorder index runs globally from 0 to end
        int preIdx; //0


        public TreeNode buildTree(int[] preorder, int[] inorder) {

            int pl = preorder.length;
            int il = inorder.length;

            if(pl == 0) return null;

            this.mapInNumIdx = new HashMap<>(); // O(n)

            //hashmap of inorder numbers to indices to find root index value
            for(int i = 0; i < il; i++){

                mapInNumIdx.put(inorder[i], i);
            }
            // full length of inorder is covered in algorithm
            return helper(preorder, inorder, 0, il-1);
        }

        public TreeNode helper(int[] preorder,int[] inorder, int start, int end){

            //base
            // if start and end cross or preorder length iteration is covered
            if(start > end || preIdx >= preorder.length || preorder.length == 0) return null;

            //logic
            //preorder's indices become roots and get updated
            int rootVal = preorder[preIdx++];

            // find root index with number in inorder which matches preorder number
            int rootIdxin = mapInNumIdx.get(rootVal);

            // create a root TreeNode that forms the output
            TreeNode root = new TreeNode(rootVal);

            //recursion over inorder
            root.left = helper(preorder, inorder, start, rootIdxin - 1); //O(n)
            root.right = helper(preorder,inorder, rootIdxin + 1, end);

            return root;

        }


/*
Time Complexity = O(n)
Space Complexity = O(n)
*/
}
