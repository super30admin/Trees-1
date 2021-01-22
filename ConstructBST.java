//TC - O(n) where n are the number of elements in input array.
//SC - O(n) 
// 1. Take a HashMap, which we will be using to store the corresponding index of each element of Inorder Traversal.
// 2. We will pass preorder and inorder both first time along with index o and last index.
// 3. Inside recursive function - we will get the index of elements from hashmap, as we already have index of each element of Inorder.
// 4. After getting index, we will increase idx for further use and construct a node with the value, which we can retrive from hashmap.
// 5. For left and right we will make recursive calls to same function, changing start and end each time.



class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) return null;
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rIdx = map.get(rootVal);
        root.left = helper(preorder, inorder, start, rIdx - 1);
        root.right = helper(preorder, inorder, rIdx + 1, end);
        return root;
    }
}
