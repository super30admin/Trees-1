//Time complexity : O(N)
//Space complexity : O(N)
// it did not run successfully
class Solution {
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder== null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);//null pointer exception
        }
        return helper(preorder, inorder, 0, preorder.length - 1);

    }
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base case
        if(start>end) return null;
        //logic
        int rootval = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootval);
        int rootindex = map.get(rootval);

        root.left = helper(preorder, inorder, start, rootindex-1);
        root.right = helper(preorder, inorder, rootindex+1, end);
        return root;
    }
}



//other solution

    time complexity: o(n2)
        space complexity: o(n2)

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        int rootindex = -1;
        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);
        for(int i = 0; i<inorder.length; i++){
            if(rootval == inorder[i]){
                rootindex = i;
                break;
            }
        }
        int[] inorderleft = Arrays.copyOfRange(inorder, 0, rootindex);
        int[] inorderright = Arrays.copyOfRange(inorder, rootindex+1, inorder.length);
        int[] preorderleft = Arrays.copyOfRange(preorder, 1, rootindex+1);
        int[] preorderright = Arrays.copyOfRange(preorder, rootindex+1, preorder.length);


        root.left = buildTree(preorderleft, inorderleft);
        root.right = buildTree(preorderright, inorderright);
        return root;
    }
}











//iterative solution


class Solution {

    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null ) return true;
        //Iterative approach
        //     Stack<TreeNode> s= new Stack<>();
        //     while(root!=null || !s.isEmpty()){
        //         while(root!=null){
        //             s.push(root);
        //             root = root.left;
        //         }
        //         root = s.pop();
        //         System.out.println(root.val+" ");
        //         root = root.right;
        //     }
        // return false;

        isValid = true;
        inorder(root);
        return isValid;
    }

    private void inorder(TreeNode root){
        // base condition
        if(root == null ) return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val ){
            isValid = false;
        }
        //System.out.println("Left: "+root.val);
        prev = root;
        inorder(root.right);
        //System.out.println("Left: "+root.val);
    }

}