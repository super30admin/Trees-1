//Time complexity - O(N)
//Space complexity - O(N)

class Solution {

    int preOrderIndex;
    Map<Integer,Integer> inorderIndexMap;

     public TreeNode buildTree(int[] preorder, int[] inorder) {

        preOrderIndex = 0;

        inorderIndexMap = new HashMap<>(); 
        for(int i = 0; i < inorder.length; i++) {

            inorderIndexMap.put(inorder[i],i);

        }

        return arrayToTree(preorder,0,preorder.length - 1);



    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {

       
        if(left > right) return null;  // No elements return null


        int rootVal = preorder[preOrderIndex++];

        TreeNode root = new TreeNode(rootVal);

        // build left and right subtree by excluding rootVal element as it is the root
        root.left = arrayToTree(preorder,left,inorderIndexMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder,inorderIndexMap.get(rootVal) + 1, right);

        return root;



    }


} 